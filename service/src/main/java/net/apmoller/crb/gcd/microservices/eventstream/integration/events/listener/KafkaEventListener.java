package net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.*;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.gsis.datedSchedule;
import net.apmoller.crb.gcd.microservices.eventstream.integration.config.IntegrationConfig;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.processor.EventProcessor;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;

@Component
@Slf4j
public class KafkaEventListener implements EventListener {

	@Autowired
	private EventProcessor eventProcessor;

	@Autowired 
	private IntegrationConfig integrationConfig;
	
	@Autowired
	private IntegrationEventStream eventStream;
	
	private static int gcssMessageCount=0;
	private static int gmsMessageCount=0;
	private static int gsisMessageCount=0;

	@Autowired
	private ObjectMapper objectMapper;

	// @Autowired
	// private GcdEventStream gcdEventStream;

	/*
	 * @Autowired Tracer tracer;
	 */

	/*
	 * @StreamListener(GcdEventStream.GCSS_CHANNEL_NAME) public void
	 * recieveBookingEvent(Message<?> eventMessage) throws Exception { long
	 * startTime = System.nanoTime(); // Acknowledgment acknowledgment = //
	 * eventMessage.getHeaders().get(ACKNOWLEDGMENT,Acknowledgment.class); //
	 * log.info("acknowledgment:: {}",acknowledgment); String eventType =
	 * eventMessage.getHeaders().get(IntegrationConstants.EVENT_TYPE, String.class);
	 * log.info("GCSS Event Message Recieved:: {} with event type:: {}",
	 * eventMessage, eventType); Booking event = new
	 * Gson().fromJson(eventMessage.getPayload().toString(), Booking.class); //
	 * log.info("Booking event after parsing: {}", event); String traceId =
	 * tracer.currentSpan().context().traceIdString();
	 * log.info("recieveBookingEvent" + "TRACEID: " + traceId);
	 * 
	 * Message<Booking> message = MessageBuilder.withPayload(event)
	 * .setHeader("eventId", "GcdEventHubListener." + UUID.randomUUID().toString())
	 * .setHeader("eventType",
	 * IntegrationConstants.INTEGRATION_EVENT).setHeader("traceId", traceId)
	 * .setHeader("eventTimeStamp",
	 * ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
	 * .setHeader("source", "GCSS").build();
	 * this.gcdEventStream.auditeventoutputchannel().send(message); log.
	 * info("Published integration audit event to Kafka event hub successfully!!");
	 * 
	 * Result result = eventProcessor.processBookingEvent(event, eventType);
	 * log.info("Result is: {}", result); long elapsedTime = (System.nanoTime() -
	 * startTime) / 1000000;
	 * log.info("recieveBookingEvent--> Time elapsed in milliseconds : {}",
	 * elapsedTime); }
	 * 
	 * @StreamListener(GcdEventStream.RKEM_CHANNEL_NAME) public void
	 * recieveEmptyContainerEvent(Message<?> eventMessage) throws Exception { long
	 * startTime = System.nanoTime(); String eventType =
	 * eventMessage.getHeaders().get(IntegrationConstants.EVENT_TYPE, String.class);
	 * log.info("RKEM Event Message Recieved:: {} with event type:: {}",
	 * eventMessage, eventType); EmptyContainer event = new
	 * Gson().fromJson(eventMessage.getPayload().toString(), EmptyContainer.class);
	 * // log.info("Booking event after parsing: {}", event);
	 * 
	 * String traceId = tracer.currentSpan().context().traceIdString();
	 * log.info("recieveEmptyContainerEvent" + "TRACEID: " + traceId);
	 * 
	 * Message<EmptyContainer> message = MessageBuilder.withPayload(event)
	 * .setHeader("eventId", "GcdEventHubListener." + UUID.randomUUID().toString())
	 * .setHeader("eventType",
	 * IntegrationConstants.INTEGRATION_EVENT).setHeader("traceId", traceId)
	 * .setHeader("eventTimeStamp",
	 * ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT))
	 * .setHeader("source", "RKEM").build();
	 * this.gcdEventStream.auditeventoutputchannel().send(message); log.
	 * info("Published integration audit event to Kafka event hub successfully!!");
	 * Result result = eventProcessor.processEmptyContainerEvent(event, eventType);
	 * log.info("Result is: {}", result); long elapsedTime = (System.nanoTime() -
	 * startTime) / 1000000;
	 * log.info("recieveEmptyContainerEvent--> Time elapsed in milliseconds : {}",
	 * elapsedTime); }
	 */

	@StreamListener(IntegrationEventStream.GMS_INPUT_CHANNEL)
	public void recieveAdvanceManifestEvent(Message<?> gmsEventMessage) throws Exception {
		Acknowledgment gmsAcknowledgment = gmsEventMessage.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
		try {
			long startTime = System.nanoTime();
			log.info("GMS AdvanceManifestEvent Message recieved from EMP Kafka::  {}", gmsEventMessage);
			log.info("GMS AdvanceManifestEvent Message recieved from EMP Kafka::  {}", gmsEventMessage.getPayload());
			ObjectMapper objectMapper = new ObjectMapper();
			LoadStatus loadStatus = objectMapper.readValue(gmsEventMessage.getPayload().toString(), LoadStatus.class);

			String eventType = new String((byte[]) gmsEventMessage.getHeaders().get("eventName"));
			log.info("AdvanceManifestEvent message parsed with eventType:: {}", eventType, " and payload:: {}", loadStatus);

			boolean processGms = Boolean.parseBoolean(integrationConfig.getProcessGmsFeed());

			if(processGms) {
				Result result = eventProcessor
						.process(AdvanceManifestEvent.getAdvanceManifestEvent(gmsEventMessage, eventType, loadStatus), eventType);
				log.info("GMS AdvanceManifestEvent processed : {}", result);
				long elapsedTime = (System.nanoTime() - startTime) / 1000000;
				log.info("recieveAdvanceManifestEvent  --> Time elapsed in milliseconds : {}", elapsedTime);
				gmsMessageCount++;
				log.info("GMS-GCD processing disabled Toggle switch processGcss: {}",processGms);
				log.info("GMS Messages Received Till Now ::{}",gmsMessageCount);

			}
			else {
				gmsMessageCount++;
				log.info("GMS-GCD processing disabled Toggle switch processGsis: {}",processGms);
				log.info("GMS Messages Received Till Now ::{}",gmsMessageCount);
			}
		} catch(Exception ex) {
			log.warn("There was an error processing the message " + ex.getMessage(),ex);
			log.warn("Sending to error channel for further processing.");
			this.eventStream.gmserroroutboundchannel()
					.send(MessageBuilder.fromMessage(gmsEventMessage).setHeader(BinderHeaders.PARTITION_OVERRIDE,
							gmsEventMessage.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID)).build());
		} finally {
			if (gmsAcknowledgment != null) {
				log.info("Acknowledgment provided for  ::{}",gmsEventMessage.getHeaders().get("X-B3-TraceId"));
				gmsAcknowledgment.acknowledge();
			}
		}
	}

	@StreamListener(IntegrationEventStream.DATED_SCHEDULE_EVENT_INPUT_CHANNEL)
	public void recieveDatedScheduleEvent(Message<?> gsisEventMessage) throws Exception{
		Acknowledgment gsisAcknowledgment = gsisEventMessage.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
		try {
			long startTime = System.nanoTime();
			log.info("GSIS dated schedule event message received from EMP:  {}", gsisEventMessage);
			log.info("GSIS dated schedule event message received from EMP:  {}", gsisEventMessage.getPayload());
			ObjectMapper objectMapper = new ObjectMapper();
			datedSchedule schedule = objectMapper.readValue(gsisEventMessage.getPayload().toString(), datedSchedule.class);
			String eventType = new String((byte[]) gsisEventMessage.getHeaders().get("eventName"));
			DatedScheduleEvent datedScheduleEvent = DatedScheduleEvent.getDatedScheduleEvent(gsisEventMessage, eventType, schedule);
			log.info("DatedScheduleEvent message parsed with eventType:: {}", eventType, " and payload:: {}",
					datedScheduleEvent.getTransportSchedule().getScheduleEntries().toString());
			boolean processGsis = Boolean.parseBoolean(integrationConfig.getProcessGsisFeed());
			if(processGsis) {
				log.info("GSIS-GCD processing disabled Toggle switch processGcss: {}",processGsis);
				log.info("GSIS Messages Received Till Now ::{}",gsisMessageCount);
				Result result = eventProcessor.process(datedScheduleEvent, eventType);
				log.info("GSIS Event Processed: " + result);
			    gsisMessageCount++;
			}
			else {
				gsisMessageCount++;
				log.info("GSIS Messages Received Till Now ::{}",gsisMessageCount);
				log.info("GSIS-GCD processing disabled Toggle switch processGsis: {}",processGsis);
				log.info("GSIS Messages Received Till Now ::{}",gsisMessageCount);
			}
			long elapsedTime = (System.nanoTime() - startTime) / 1000000;
			log.info("recieveDatedScheduleEvent --> Time elapsed in milliseconds : {}", elapsedTime);
		} catch(Exception ex) {
			log.warn("There was an error processing the message " + ex.getMessage(),ex);
			log.warn("Sending to error channel for further processing.");
			this.eventStream.gsiserroroutboundchannel()
					.send(MessageBuilder.fromMessage(gsisEventMessage).setHeader(BinderHeaders.PARTITION_OVERRIDE,
							gsisEventMessage.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID)).build());
		} finally {
			if (gsisAcknowledgment != null) {
				log.info("GSIS Acknowledgment provided for  ::{}",gsisEventMessage.getHeaders().get("X-B3-TraceId"));
				gsisAcknowledgment.acknowledge();
			}
		}
	}


	@StreamListener(IntegrationEventStream.GCSS_INPUT_CHANNEL)
	public void receiveGCSSEvent(Message<?> gcssEventMessage ) {
		Acknowledgment gcssAcknowledgment = gcssEventMessage.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
		try {
			boolean processGcss = Boolean.parseBoolean(integrationConfig.getProcessGcssFeed());
			log.info("GCSS message recieved from EMP Kafka with segmentId and traceId :: {} {}", new String((byte[]) gcssEventMessage.getHeaders().get("segmentId")),gcssEventMessage.getHeaders().get("X-B3-TraceId") );
			if(!processGcss) {
				gcssMessageCount++;
				log.info("GCSS-GCD processing disabled Toggle switch processGcss: {}",processGcss);
				log.info("GCSS Messages Received Till Now ::{}",gcssMessageCount);
			}
			else {
				gcssMessageCount++;
				log.info("GCSS-GCD processing disabled Toggle switch processGcss: {}",processGcss);
				log.info("GCSS Messages Received Till Now ::{}",gcssMessageCount);
				eventProcessor.process(gcssEventMessage);
				log.info("Message Headers::{}",gcssEventMessage.getHeaders());
				
			}
		} catch(Exception ex) {
			log.warn("There was an error processing the message " + ex.getMessage(),ex);
			log.warn("Sending to error channel for further processing.");
			this.eventStream.gcsserroroutboundchannel()
					.send(MessageBuilder.fromMessage(gcssEventMessage).setHeader(BinderHeaders.PARTITION_OVERRIDE,
							gcssEventMessage.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION_ID)).build());
		} finally {
			if (gcssAcknowledgment != null) {
				log.info("GCSS Acknowledgment provided for  ::{}",gcssEventMessage.getHeaders().get("X-B3-TraceId"));
				gcssAcknowledgment.acknowledge();
			}
		}
	}

}