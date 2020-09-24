package net.apmoller.crb.gcd.microservices.eventstream.integration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.CustomsInboundResponseDocument;
import net.apmoller.crb.gcd.microservices.eventstream.integration.repository.InboundResponseRepository;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CustomsProcessorServiceImpl implements CustomsProcessorService{
	
	@Autowired
	private InboundResponseRepository inboundResponseRepository;
	

	public Flux<CustomsInboundResponseDocument> saveOrUpdateAll(List<CustomsInboundResponseDocument> customRespList) {
		Flux<CustomsInboundResponseDocument> fluxCustomsRespList =  inboundResponseRepository.saveAll(customRespList).switchIfEmpty(Mono.error(new Exception(IntegrationConstants.DATA_UPDATE_ERROR)));
		log.info("Response List Size>>>"+fluxCustomsRespList.toStream().count());
		return fluxCustomsRespList;
	}

}
