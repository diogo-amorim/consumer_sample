package net.apmoller.crb.gcd.microservices.eventstream.integration.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.OffsetDateTime;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobAccessPolicy;
import com.azure.storage.blob.models.BlobSignedIdentifier;
import com.azure.storage.blob.models.PublicAccessType;
import com.azure.storage.blob.specialized.BlockBlobClient;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BlobAdapter {
	
	@Autowired
	private BlobServiceClient blobServiceClient;
	
	
	public BlobContainerClient createContainer(String containerName){
	BlobContainerClient blobContainer = null;	 
    if(blobServiceClient.getBlobContainerClient(containerName).exists()){
    	 log.info(containerName + " already exists..");
    	 blobContainer = blobServiceClient.getBlobContainerClient(containerName);
     } else{
    	 log.info(containerName + " does not exists, creating a new one..");
    	 blobContainer = blobServiceClient.createBlobContainer(containerName);
     }
    
     BlobSignedIdentifier identifier = new BlobSignedIdentifier()
            .setId("name")
            .setAccessPolicy(new BlobAccessPolicy()
                .setStartsOn(OffsetDateTime.now())
                .setExpiresOn(OffsetDateTime.now().plusDays(2))
                .setPermissions("permissionString"));
	 // blobContainer.setAccessPolicy(PublicAccessType.CONTAINER,  Collections.singletonList(identifier));
	  blobContainer.setAccessPolicy(PublicAccessType.BLOB, null);
      return blobContainer;
	}
	
    public List<URL> listBlobs(BlobContainerClient blobContainerClient){
        List<URL> urls = new ArrayList<>();
        String containerUrl = blobContainerClient.getBlobContainerUrl();
    	log.info("Container URL: {}",containerUrl);
        blobContainerClient.listBlobs().forEach(blobItem->{
        	log.info("Blob found with name: {}",blobItem.getName());
        	StringBuilder sb = new StringBuilder().append(containerUrl).append("/").append(blobItem.getName());
			try {
	        	log.info("url String: {}",sb.toString());
				URL url = new URL(sb.toString());
	        	urls.add(url);
			} catch (IOException e){
				log.error(e.toString());;
			}
        });
        return urls;
    }
    
	public List<String> listBlobNames(List<URL> urlList) {
		List<String> blobNames = new ArrayList<>();
		urlList.stream().forEach(url -> {
			String fileName = url.getFile().split("/")[2];
			log.info("fileName: " + fileName);
			blobNames.add(fileName);
		});
		return blobNames;
	}
    
	
    public void deleteBlobs(String containerName, List<String> blobNames){
    	BlobContainerClient blobContainer =  blobServiceClient.getBlobContainerClient(containerName);
    	blobNames.stream().forEach(blob->{
        	BlobClient blobClient = blobContainer.getBlobClient(blob);
        	log.info("deleting blob: "+blob);
        	blobClient.delete();
        	
    	});
    }   
    
    public void uploadBlobsToContainer(BlobContainerClient blobContainer, List<URL> urlList, boolean archiveFlag) {
    	//List<File> fileList = new ArrayList<>();
    	urlList.stream().forEach(url->{
    		String blobName = archiveFlag ? "archive/"+ url.getFile().split("/")[2] : url.getFile().split("/")[2];
    		log.info("uploadBlobsToContainer blobName : {}", blobName);
    		InputStream initialStream = null;
    		OutputStream outStream = null;
    		try {
    		URLConnection connection = url.openConnection();
        	initialStream = connection.getInputStream();
        	byte[] buffer = new byte[initialStream.available()];
        	initialStream.read(buffer);
        	String fileName = blobName.substring(0, blobName.indexOf("."));
        	log.info("fileName {}", fileName);
        	File file = File.createTempFile(fileName, ".xml");
        	outStream = new FileOutputStream(file);
        	outStream.write(buffer);
        	FileInputStream fis = new FileInputStream(file);
        	BlockBlobClient blockBlobClient = blobContainer.getBlobClient(blobName).getBlockBlobClient();
			blockBlobClient.upload(initialStream, initialStream.available());
			//fileList.add(file);
    		} catch(IOException ex){
    			log.error(ex.toString());
    		} finally{
    			try {
					initialStream.close();
	    			//outStream.close();	    			
				} catch (IOException e) {
				   log.error(e.toString());
				}
    			
    		}
    	});
    }    
}

