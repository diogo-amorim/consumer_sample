package net.apmoller.crb.gcd.microservices.eventstream.integration.events.processor;

import java.util.List;
import java.util.stream.Collectors;

import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.BookingEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventHandler;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventToHandlerMapper;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BaseEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.Booking;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.ComplianceRequest;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.EmptyContainer;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.Routes;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class EventProcessor {
	
	/*@Autowired
	private EventHandler eventHandler;*/
	
	@Autowired
	private EventToHandlerMapper handlerMapper;

	@Autowired
	private BookingEventHandler bookingEventHandler;
	

/*
	public Result processBookingEvent(Booking bookingEvent, String eventType) {
		log.info("In processBookingEvent>>");
		WebClient tpDocWebClient = WebClient.create(IntegrationConstants.TPDOC_API_BASEURL);
		WebClient complianceWebClient = WebClient.create(IntegrationConstants.COMPLIANCE_API_BASEURL);

		final Mono<ClientResponse> serviceResponse = tpDocWebClient.post().uri(IntegrationConstants.TPDOC_URL)
				.contentType(MediaType.APPLICATION_JSON).body(Mono.just(bookingEvent), Booking.class).exchange()
				.retry(3).log("tpDoc API call").flatMap(booking -> {
					return booking.bodyToMono(Booking.class).flatMap(obj -> {
						String tpDocNum = obj.getTpDocumentNo();
						System.out.println("tpDocNum::" + tpDocNum);
						ComplianceRequest complianceRequest = new ComplianceRequest();
						complianceRequest.setTpDocumentNo(tpDocNum);
						List<Routes> routes = obj.getShipments().stream()
								.flatMap(shipment -> shipment.getRoutes().stream()).map(route -> {
									return route;
								}).collect(Collectors.toList());
						complianceRequest.setRoutes(routes);
						System.out.println("complianceRequest::" + complianceRequest.toString());
						// compliance service call
						return complianceWebClient.post().uri(IntegrationConstants.COMPLIANCE_URL).contentType(MediaType.APPLICATION_JSON)
								.body(Mono.just(complianceRequest), ComplianceRequest.class).exchange().retry(3)
								.log("compliance API call");
					});
				});

		serviceResponse.map(ClientResponse::statusCode)
				.subscribe(status -> log.info("Compliance POST call>> " + status.getReasonPhrase()));
		return Result.PROCESSED;
	}

	public Result processEmptyContainerEvent(EmptyContainer emptyContainer, String eventType) {
		log.info("In processEmptyContainerEvent>>");
		WebClient tpDocWebClient = WebClient.create(IntegrationConstants.TPDOC_API_BASEURL);
		WebClient complianceWebClient = WebClient.create(IntegrationConstants.COMPLIANCE_API_BASEURL);

		final Mono<ClientResponse> serviceResponse =
				// tpDoc service call
				tpDocWebClient.post().uri(IntegrationConstants.EMPTY_TPDOC_URL).contentType(MediaType.APPLICATION_JSON)
						.body(Mono.just(emptyContainer), EmptyContainer.class).exchange().retry(3).log("tpDoc API call")
						.flatMap(empty -> {
							return empty.bodyToMono(EmptyContainer.class).flatMap(obj -> {
								String tpDocNum = obj.getTpDocumentNo();
								System.out.println("tpDocNum::" + tpDocNum);
								ComplianceRequest complianceRequest = new ComplianceRequest();
								complianceRequest.setTpDocumentNo(tpDocNum);
								List<Routes> routes = obj.getRoutes().stream().map(route -> {
									return route;
								}).collect(Collectors.toList());
								complianceRequest.setRoutes(routes);
								System.out.println("complianceRequest::" + complianceRequest.toString());
								// compliance service call
								return complianceWebClient.post().uri(IntegrationConstants.COMPLIANCE_URL)
										.contentType(MediaType.APPLICATION_JSON)
										.body(Mono.just(complianceRequest), ComplianceRequest.class).exchange().retry(3)
										.log("compliance API call");
							});
						});

		serviceResponse.map(ClientResponse::statusCode)
				.subscribe(status -> log.info("Compliance POST call>> " + status.getReasonPhrase()));
		return Result.PROCESSED;
	}
*/
	
	public Result process(BaseEvent event, String eventType) {
		log.info("EventProcessor>> eventType {}",eventType);
		//return event.handle(eventHandler);	
		return event.handle(handlerMapper);
	}

	public void process(Message<?> message) {
		//return event.handle(eventHandler);
		bookingEventHandler.handleMessage(message);
	}
}
