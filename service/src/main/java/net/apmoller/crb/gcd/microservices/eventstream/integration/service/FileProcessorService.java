package net.apmoller.crb.gcd.microservices.eventstream.integration.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessorService {

	void saveFiles(MultipartFile[] files) throws IOException;
	
	void uploadToBlobStorage(MultipartFile[] files) throws InvalidKeyException, MalformedURLException, IOException;
	
	//void deleteDirectory();
	
	void deleteFilesInDirectory() throws IOException;

	//void downloadFromBlobStorage() throws IOException, InvalidKeyException;
	
	void processInboundBlobs() throws IOException;
	
}
