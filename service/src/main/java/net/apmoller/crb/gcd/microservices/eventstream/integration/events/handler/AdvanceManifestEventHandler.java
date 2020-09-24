package net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.api.client.ComplianceApiClient;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifest;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifestEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BaseEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.publisher.ContainerLoadStatusEventPublisher;
import net.apmoller.crb.gcd.microservices.eventstream.integration.exception.ManifestDataException;

@Service
@Log4j2
public class AdvanceManifestEventHandler implements EventHandler {

	@Autowired
	private ComplianceApiClient complianceApiClient;

	@Autowired
	private ContainerLoadStatusEventPublisher publisher;

	@Override
	public Result handle(BaseEvent event) {
		log.info("AdvanceManifestEventHandler >> handle");
		AdvanceManifestEvent advanceManifestEvent = (AdvanceManifestEvent) event;
		AdvanceManifest advManifestPayload = advanceManifestEvent.getManifest().getAdvanceManifest();
		try {
			complianceApiClient.callComplianceApiByManifest(advManifestPayload).doOnSuccess(resp -> {
				log.info("Compliance Api call success with response >>{}", resp);
				publisher.publishEvent(resp);
			}).block();
		} catch (ManifestDataException ex) {
			log.error("Error invoking compliance api {}", ex);
			return Result.FAILED;
		}
		return Result.PROCESSED;
	}

}
