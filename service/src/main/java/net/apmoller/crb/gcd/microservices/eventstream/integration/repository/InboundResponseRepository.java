package net.apmoller.crb.gcd.microservices.eventstream.integration.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.CustomsInboundResponseDocument;

@Repository
public interface InboundResponseRepository extends ReactiveMongoRepository<CustomsInboundResponseDocument,String>{
	
	

}
