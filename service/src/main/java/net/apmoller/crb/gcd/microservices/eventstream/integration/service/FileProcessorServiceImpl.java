package net.apmoller.crb.gcd.microservices.eventstream.integration.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.azure.storage.blob.BlobContainerClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.azure.storage.blob.BlobRange;
import com.microsoft.azure.storage.blob.BlockBlobURL;
import com.microsoft.azure.storage.blob.ContainerURL;
import com.microsoft.azure.storage.blob.ListBlobsOptions;
import com.microsoft.azure.storage.blob.ListContainersOptions;
import com.microsoft.azure.storage.blob.PipelineOptions;
import com.microsoft.azure.storage.blob.ReliableDownloadOptions;
import com.microsoft.azure.storage.blob.ServiceURL;
import com.microsoft.azure.storage.blob.SharedKeyCredentials;
import com.microsoft.azure.storage.blob.StorageURL;
import com.microsoft.azure.storage.blob.TransferManager;
import com.microsoft.azure.storage.blob.models.BlobItem;
import com.microsoft.azure.storage.blob.models.ContainerListBlobFlatSegmentResponse;
import com.microsoft.rest.v2.RestException;
import com.microsoft.rest.v2.util.FlowableUtil;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.CustomsInboundResponseDocument;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.ResponseMessage;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.BlobAdapter;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.CustomDateDeserializer;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.CustomDateSerializer;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Flux;

@Service
@Slf4j
public class FileProcessorServiceImpl implements FileProcessorService {

	@Autowired
	private Environment environment;
		
	@Autowired
	private CustomsProcessorService customsProcessorService;
	
	@Autowired
	private BlobAdapter blobAdapter;
	

	public void saveFiles(MultipartFile[] files) throws IOException {
		for (MultipartFile uploadedFile : files) {
			if (!uploadedFile.isEmpty()) {
				byte[] bytes = uploadedFile.getBytes();
				Path basePath = Paths.get(IntegrationConstants.OUTBOUND_UPLOAD_LOC);
				if (!Files.exists(basePath)) {
					Files.createDirectory(basePath);
				}
				log.info("Writing file-->" + uploadedFile.getOriginalFilename() + " in directory-->"
						+ basePath.toString());
				Files.write(Paths.get(basePath.toString() + File.separator + uploadedFile.getOriginalFilename()),
						bytes);
			}
		}
	}

	public void uploadToBlobStorage(MultipartFile[] files) throws InvalidKeyException, IOException {

		String accountName = environment.getProperty("azure.storage.account.name");
		String accountKey = environment.getProperty("azure.storage.account.key");
		String endpoint = String.format(Locale.ROOT, "https://%s.blob.core.windows.net",
				environment.getProperty("azure.storage.account.name"));
		String containerName = environment.getProperty("azure.storage.container.name");
		log.info("uploadToBlobStorage>> accountName:: {},  endpoint:: {}, containerName:: {}", accountName, endpoint,
				containerName);
		SharedKeyCredentials creds = new SharedKeyCredentials(accountName, accountKey);
		final int blockLength = 100 * 1024;

		// Create a ServiceURL to call the Blob service. We will also use this
		// to construct the ContainerURL
		final ServiceURL serviceURL = new ServiceURL(new URL(endpoint),
				StorageURL.createPipeline(creds, new PipelineOptions()));

		// Create a container using a blocking call to Azure Storage
		// If container exists, we will not create it again
		ContainerURL containerURL = serviceURL.createContainerURL(containerName);
		final List<String> containerList = new ArrayList<>();
		serviceURL.listContainersSegment(null, new ListContainersOptions()).blockingGet().body().containerItems()
				.forEach(container -> {
					String name = container.name();
					log.info("adding containerName/s:" + name + "to List");
					containerList.add(name);

				});
		
		serviceURL.listContainersSegment(null, new ListContainersOptions()).subscribe(x->{
			x.body().containerItems().forEach(item->{
				String name = item.name();
				log.info("adding containerName/s:" + name + " to List");
				containerList.add(name);
			});
		});
		
		if (!containerList.contains(containerName)) {
			containerURL.create(null, null, null);
		}
		
		// local Directory where files are uploaded
		Path outboundFilePath = Paths.get(IntegrationConstants.OUTBOUND_UPLOAD_LOC);
		// Walk the directory and filter for .xml files
		Stream<Path> walk = Files.walk(outboundFilePath).filter(p -> p.toString().endsWith(".xml"));
        try{
		Observable.fromIterable(() -> walk.iterator()).flatMap(file -> {
			log.info("fileName:: " + file.getFileName().toString());
			BlockBlobURL blobURL = containerURL.createBlockBlobURL(file.getFileName().toString());
			AsynchronousFileChannel fc = AsynchronousFileChannel
					.open(Paths.get(outboundFilePath.toString() + File.separator + file.getFileName().toString()));
			return TransferManager
					//.uploadFromNonReplayableFlowable(Flux.just(ByteBuffer.wrap(x.getBytes())), blobURL, 1024, 100, null)
					.uploadFileToBlockBlob(fc, blobURL, blockLength, null)
					.toObservable()
					.doOnError(throwable -> {
						if (throwable instanceof RestException) {
							log.info("Failed to upload " + outboundFilePath + " with error:"
									+ ((RestException) throwable).response().statusCode());
						} else {
							log.error(throwable.getMessage());
						}
					}).doAfterTerminate(() -> {
						log.info("Upload of " + file + " completed");
						fc.close();
					});

		}, 20).subscribe(response -> {
			log.info("Completed upload request with Status:: {}" + response.response().statusCode());
		});
       } finally{
    	   walk.close();
       }
	}

/*	public void deleteDirectory() {
		try {
			Path pathToBeDeleted = Paths.get(IntegrationConstants.OUTBOUND_UPLOAD_LOC);
			Files.walk(pathToBeDeleted).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);

		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}*/

	public void deleteFilesInDirectory() throws IOException {
		
		Path path = Paths.get(IntegrationConstants.OUTBOUND_UPLOAD_LOC);
		if (Files.isDirectory(path)) {
			try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
				for (Path entry : entries) {
					Files.delete(entry);
				}
			}
		}
	}

	/*public void downloadFromBlobStorage() throws IOException, InvalidKeyException {
		
		String accountName = environment.getProperty("azure.storage.account.name");
		String accountKey = environment.getProperty("azure.storage.account.key");
		String endpoint = String.format(Locale.ROOT, "https://%s.blob.core.windows.net",
				environment.getProperty("azure.storage.account.name"));
		String containerName = environment.getProperty("azure.storage.container.name");
		log.info("downloadFromBlobStorage>> accountName:: {},  endpoint:: {}, containerName:: {}", accountName, endpoint,
				containerName);
		SharedKeyCredentials creds = new SharedKeyCredentials(accountName, accountKey);
		// Create a ServiceURL to call the Blob service. We will also use this
		// to construct the ContainerURL
		final ServiceURL serviceURL = new ServiceURL(new URL(endpoint),
				StorageURL.createPipeline(creds, new PipelineOptions()));

		// Create a container using a blocking call to Azure Storage
		// If container exists, we will not create it again
		ContainerURL containerURL = serviceURL.createContainerURL(containerName);

		Path basePath = Paths.get(IntegrationConstants.INBOUND_DOWNLOAD_LOC);
		if (!Files.exists(basePath)) {
			Files.createDirectory(basePath);
		}
		
		ListBlobsOptions options = new ListBlobsOptions();
		options.withMaxResults(500);

		File filePath = new File(IntegrationConstants.INBOUND_DOWNLOAD_LOC);
		List<BlockBlobURL> blockBlobUrlList = new ArrayList<>();
		List<BlockBlobURL> UrlList =
				containerURL.listBlobsFlatSegment(null, options, null)
				.flatMap(containerListBlobFlatSegmentResponse -> listAllBlobs(containerURL,
						containerListBlobFlatSegmentResponse))
				.flatMap(containerListResponse->{
					Map<BlockBlobURL,String> blobNameMap = new HashMap<>();
					containerListResponse.body().segment().blobItems().stream().forEach(blobItem->{
						String blobName = blobItem.name();
						BlockBlobURL blobURL = containerURL.createBlockBlobURL(blobName);
						blobNameMap.put(blobURL, blobName);
						blockBlobUrlList.add(blobURL);
					});
				return getBlobs(blockBlobUrlList, blobNameMap, filePath);
					//return Single.just(blobNameMap);
				}).blockingGet();
		
		        uploadToArchive(serviceURL);
				List<CustomsInboundResponseDocument> listToPersist = listDocumentsToPersist(filePath);
				customsProcessorService.saveOrUpdateAll(listToPersist);
				UrlList.stream().forEach(url -> {
					url.delete().subscribe(y->log.info("Deleting the file:" + url.toString()));
				});				

				.flatMap(resp->{
					    x->uploadToArchiveAndDelete(serviceURL);
				});
		
					getBlobs(resp, filePath, serviceURL);
					log.info("resp>>"+resp);
					List<CustomsInboundResponseDocument> listToPersist = listDocumentsToPersist(filePath);
					customsProcessorService.saveOrUpdateAll(listToPersist);
					blobUrlList.stream().forEach(url -> {
						url.delete().subscribe(y->log.info("Deleting the file:" + url.toString()));
					});				
				subscribe(response->
				log.info("downloading file in local drive"+response.size()));
						try {
							uploadToArchiveAndDelete(serviceURL);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				//}).doAfterTerminate( ()->{
					List<CustomsInboundResponseDocument> listToPersist=  listDocumentsToPersist(filePath);
					customsProcessorService.saveOrUpdateAll(listToPersist);
					blobUrlList.stream().forEach(url->{
						log.info("Deleting the file:"+url.toString());
						url.delete().blockingGet();
					});
				//}).subscribe();
		
	//	File file = new File("https://gcdeventstore.blob.core.windows.net/gcdoutboundcontainer");
	//	uploadToArchiveAndDelete(UrlList, serviceURL);
		
				doAfterSuccess(urlList->{
					log.info("Downloaded file count::"+urlList.stream().count());
					persistInboundCustomsResponse(filePath);
				})
				.subscribe();
				.doOnSuccess(containerListResponse->{
					List<BlockBlobURL> blobUrlList= new ArrayList<>();
					Map<BlockBlobURL,String> blobNameMap = new HashMap<>();
					containerListResponse.body().segment().blobItems().stream().forEach(blobItem->{
						String blobName = blobItem.name();
						BlockBlobURL blobURL = containerURL.createBlockBlobURL(blobName);
						blobNameMap.put(blobURL, blobName);
						blobUrlList.add(blobURL);
					});
					getBlobs(blobUrlList, blobNameMap, new File(IntegrationConstants.INBOUND_DOWNLOAD_LOC));
				})
				subscribe(response -> {
					log.info("Completed list blobs request>> with statusCode: {}",response);
				});
	}
	
	private static Single<ContainerListBlobFlatSegmentResponse> listAllBlobs(ContainerURL url,
			ContainerListBlobFlatSegmentResponse response) {

		log.info("In listAllBlobs url>>"+response.body().serviceEndpoint());

		if (response.body().segment() != null) {
			for (BlobItem b : response.body().segment().blobItems()) {
				String output = "Blob name: " + b.name();
				if (b.snapshot() != null) {
					output += ", Snapshot: " + b.snapshot();
				}
				log.info(output);
			}
		} else {
			log.info("There are no more blobs to list off.");
		}

		if (response.body().nextMarker() == null) {
			return Single.just(response);
		} else {
			String nextMarker = response.body().nextMarker();
			return url.listBlobsFlatSegment(nextMarker, new ListBlobsOptions().withMaxResults(10), null).flatMap(
					containersListBlobFlatSegmentResponse -> listAllBlobs(url, containersListBlobFlatSegmentResponse));
		}
	}
	
	private Single<List<BlockBlobURL>> getBlobs(List<BlockBlobURL> blobList, Map<BlockBlobURL,String> nameMap, File sourceFile ) {
		log.info("in getBlobs>>");
	    try {
	        // Get the blob using the low-level download method in BlockBlobURL type
	        // FlowableUtil is a static class that contains helpers to work with Flowable
	    	blobList.stream().forEach(blobUrl->{
            	String blobName = nameMap.get(blobUrl);
	    		blobUrl.download(new BlobRange(), null, false,null)
	            .flatMapCompletable(response -> {
	                AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths
	                    .get(sourceFile.getPath()+ File.separator + blobName), StandardOpenOption.CREATE,  StandardOpenOption.WRITE);
	                        return FlowableUtil.writeFile(response.body(new ReliableDownloadOptions().withMaxRetryRequests(3)), channel);
	            })
	            .doOnComplete(()-> {
	            log.info("The blob :"+ blobName + " was downloaded to " + sourceFile.getAbsolutePath());
	            }
	            )
	           .blockingAwait();
	           subscribe(()->{
	        	   log.info("downloaded and uploaded");
		           // uploadToArchiveAndDelete(serviceURL);
	           });
	            // To call it synchronously add .blockingAwait()
	    	});
	      } catch (Exception ex){
	        log.error(ex.toString());
	      }
	    return Single.just(blobList);
	}
*/	
/*	private List<CustomsInboundResponseDocument> listDocumentsToPersist(File source) throws IOException{
		Path inboundFilePath = source.toPath();
		if (!Files.exists(inboundFilePath)) {
			Files.createDirectory(inboundFilePath);
		}
		// Walk the directory and filter for .xml files
		Stream<Path> walk = Files.walk(inboundFilePath).filter(p -> p.toString().endsWith(".xml"));
		List<CustomsInboundResponseDocument> docList = new ArrayList<>();		
		try{
			walk.forEach(file->{
				log.info("file:: "+file.getFileName().toString()+ " found");
				try {
					JAXBContext context = JAXBContext.newInstance(ResponseMessage.class);    
		            Unmarshaller unmarshaller = context.createUnmarshaller();
		            ResponseMessage responseMessage = (ResponseMessage) unmarshaller
		            		.unmarshal(new FileInputStream(new File(inboundFilePath.toString()+File.separator+file.getFileName().toString())));
		              GsonBuilder gsonBuilder = new GsonBuilder();
		              gsonBuilder.setPrettyPrinting().disableHtmlEscaping()
		              .registerTypeAdapter(Date.class, new CustomDateSerializer())
		              .registerTypeAdapter(Date.class, new CustomDateDeserializer());
		    
		              Gson gson = gsonBuilder.create();
		              String jsonStr = gson.toJson(responseMessage, ResponseMessage.class);
		              
		              CustomsInboundResponseDocument response = gson.fromJson(jsonStr, CustomsInboundResponseDocument.class);
		              log.info("Customs Response>> {}",gson.toJson(response));
		              docList.add(response);
				} catch (IOException | JAXBException ex) {
					log.error(ex.toString());
				}
			});
			log.info("customs response fileList size::"+docList.size());
		} finally {
			walk.close();
		}
		return docList;
	}
	*/
	
	private List<CustomsInboundResponseDocument> createDocumentsFromBlobToPersist(List<URL> urlList) throws IOException{
	
		List<CustomsInboundResponseDocument> docList = new ArrayList<>();
			urlList.stream().forEach(file->{
				URLConnection connection = null;
				try {
					connection = file.openConnection();
					JAXBContext context = JAXBContext.newInstance(ResponseMessage.class);    
		            Unmarshaller unmarshaller = context.createUnmarshaller();
		            ResponseMessage responseMessage = (ResponseMessage) unmarshaller
		            		.unmarshal(connection.getInputStream());
		              GsonBuilder gsonBuilder = new GsonBuilder();
		              gsonBuilder.setPrettyPrinting().disableHtmlEscaping()
		              .registerTypeAdapter(Date.class, new CustomDateSerializer())
		              .registerTypeAdapter(Date.class, new CustomDateDeserializer());
		    
		              Gson gson = gsonBuilder.create();
		              String jsonStr = gson.toJson(responseMessage, ResponseMessage.class);
		              
		              CustomsInboundResponseDocument response = gson.fromJson(jsonStr, CustomsInboundResponseDocument.class);
		              log.info("Customs Response>> {}",gson.toJson(response));
		              docList.add(response);
				} catch (IOException | JAXBException ex) {
					log.error(ex.toString());
				} 
			});
			log.info("customs response fileList size::"+docList.size());
			return docList;
	}
	
/*	private void uploadToArchive(final ServiceURL serviceURL) throws IOException{
		log.info("in uploadToArchiveAndDelete>>");
		ContainerURL containerURL = serviceURL.createContainerURL("gcdoutboundcontainer/inboundarchive");
		containerURL.create();
		Path inboundFilePath = Paths.get(IntegrationConstants.INBOUND_DOWNLOAD_LOC);
		// Walk the directory and filter for .xml files
		Stream<Path> walk = Files.walk(inboundFilePath).filter(p -> p.toString().endsWith(".xml"));
		walk.forEach(x->{
			log.info("fileName:: " + x.getFileName().toString());
			BlockBlobURL blobURL = containerURL.createBlockBlobURL(x.getFileName().toString());
			byte[] bFile = null;
			try {
				bFile = Files.readAllBytes(Paths.get(inboundFilePath.toString()+File.separator+x.getFileName().toString()));
				log.info(String.valueOf(bFile.length));
			} catch (IOException e) {
              log.error(e.toString());
              }
			//moving the blobs to archive container location
			blobURL.upload(Flowable.just(ByteBuffer.wrap(bFile)), Long.valueOf(bFile.length))
			//.subscribe(res->log.info("uploaded "+x.toString()));
			.blockingGet();
		});
		//delete the blobs from main folder in azure storage blob container
		blobUrls.stream().forEach(url->{
			log.info("Deleting the file:"+url.toString());
			url.delete().blockingGet();
		});	
	}*/

	public void processInboundBlobs() throws IOException {
		
		BlobContainerClient blobContainerClient= blobAdapter.createContainer(environment.getProperty("azure.storage.container.name"));
		List<URL> urlList = blobAdapter.listBlobs(blobContainerClient);
		log.info("urlList size>> "+urlList.size());
		if(urlList.size() > 0){
		List<String> listBlobNames = blobAdapter.listBlobNames(urlList);
		List<CustomsInboundResponseDocument> customsInboundResponseList = createDocumentsFromBlobToPersist(urlList);
		customsProcessorService.saveOrUpdateAll(customsInboundResponseList);
				
		// copy and upload the blobs from main folder to archive folder of inbound container
	    blobAdapter.uploadBlobsToContainer(blobContainerClient, urlList, true);
	    
		//delete the blobs from main folder of inbound container
		blobAdapter.deleteBlobs(environment.getProperty("azure.storage.container.name"), listBlobNames);
		}

	}
}