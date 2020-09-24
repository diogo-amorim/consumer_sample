package net.apmoller.crb.gcd.microservices.eventstream.integration.service;

import java.util.List;

import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.CustomsInboundResponseDocument;
import reactor.core.publisher.Flux;

public interface CustomsProcessorService {

	Flux<CustomsInboundResponseDocument> saveOrUpdateAll(List<CustomsInboundResponseDocument> customRespList);

}
