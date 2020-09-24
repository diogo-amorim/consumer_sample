package net.apmoller.crb.gcd.microservices.eventstream.integration.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobServiceAsyncClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j*/
public class AzureAsyncBeanConfig {

/*    @Autowired
    private Environment environment;
    
    @Bean
    public BlobContainerAsyncClient blobContainerAsyncClient(){
    	
    	String endpoint = String.format(Locale.ROOT, "https://%s.blob.core.windows.net", environment.getProperty("azure.storage.account.name"));
    	log.info("AzureAsyncBeanConfig:: endpoint found: {}",endpoint);
        BlobServiceAsyncClient storageClient = new BlobServiceClientBuilder().endpoint(endpoint)
        		.credential(new StorageSharedKeyCredential(environment.getProperty("azure.storage.account.name"), 
        				environment.getProperty("azure.storage.account.key")))
                .buildAsyncClient();

        return storageClient.getBlobContainerAsyncClient(environment.getProperty("azure.storage.container.name"));
    }*/
	 
	
}
