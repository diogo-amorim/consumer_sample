package net.apmoller.crb.gcd.microservices.eventstream.integration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlobBeanConfig {
	
	@Autowired
    private Environment environment;
	
	@Bean
	public BlobServiceClient blobServiceClient(){
    StorageSharedKeyCredential credential = new 
    		StorageSharedKeyCredential(environment.getProperty("azure.storage.account.name"), 
    				environment.getProperty("azure.storage.account.key"));
	
	return new BlobServiceClientBuilder()
			.connectionString(environment.getProperty("azure.storage.connectionstring"))
			.credential(credential)
			.buildClient();
	}
		
}
