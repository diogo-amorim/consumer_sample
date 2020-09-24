package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.ComplianceLoadStatus;
import org.apache.kafka.common.protocol.types.Field;
import org.joda.time.DateTime;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventHandler;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventToHandlerMapper;
import org.springframework.util.ObjectUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Builder
@Component
@Log4j2
public class AdvanceManifestEvent extends BaseEvent {
	
	@JsonProperty("Manifest")
	private Manifest manifest;
		
	public static AdvanceManifestEvent parse(Message<?> message, ObjectMapper objectMapper) throws IOException {

		AdvanceManifestEvent advanceManifestEvent = objectMapper.readValue(message.getPayload().toString(),
				AdvanceManifestEvent.class);
		log.info("AdvanceManifestEvent event after parsing: {}", advanceManifestEvent.toString());
		if (advanceManifestEvent.getManifest().getMessageHeader().getTraceId() == null) {
			String traceId = advanceManifestEvent.getManifest().getMessageHeader().getCorrelationId()!=null 
					?advanceManifestEvent.getManifest().getMessageHeader().getCorrelationId()
					: message.getHeaders().get("spanTraceId").toString();
			log.info("setting traceId to correlationId/kafka header spanTraceId if it is not sent in event::{}", traceId);
			advanceManifestEvent.getManifest().getMessageHeader().setTraceId(traceId);
		}
		return advanceManifestEvent;
	}

	public static AdvanceManifestEvent getAdvanceManifestEvent(Message<?> message, String eventName,LoadStatus loadStatus){
		MessageHeader messageHeader=new MessageHeader();
		messageHeader.setCorrelationId(new String((byte[]) message.getHeaders().get("correlationID")));
		messageHeader.setEventName(eventName);
		messageHeader.setTraceId(messageHeader.getCorrelationId());
		messageHeader.setMessageGeneratedTimestamp(DateTime.now());
		messageHeader.setMessageId(new String((byte[]) message.getHeaders().get("messageID")));
		messageHeader.setCausationId(new String((byte[]) message.getHeaders().get("causationID")));

		AdvanceManifest advanceManifest=AdvanceManifest.builder()
				.transportDocumentNumber(loadStatus.getTransportDocumentNumber().toString())
				.arrivalVoyageNumber(loadStatus.getArrivalVoyageNumber().toString())
				.complianceLoadStatus(loadStatus.getComplianceLoadStatus().toString())
				.complianceReceiverPort(loadStatus.getComplianceReceiverPort().toString())
				.complianceStatus(loadStatus.getComplianceStatus().toString())
				.customsResponseReason(loadStatus.getCustomsResponseReason().toString())
				.departureVoyageNumber(loadStatus.getDepartureVoyageNumber().toString())
				.dischargePort(loadStatus.getDischargePort().toString())
				.mrnCustomsNumber(loadStatus.getMRNCustomsNumber().toString())
				.vesselCode(loadStatus.getVesselCode().toString())
				.build();
		if (!ObjectUtils.isEmpty(loadStatus.getEntryPortETA()))
			advanceManifest.setEntryPortEta(LocalDateTime.parse(loadStatus.getEntryPortETA().toString().replace(" ", "T")));
		if (!ObjectUtils.isEmpty(loadStatus.getSentTimeStamp()))
			advanceManifest.setSentTimeStamp(LocalDateTime.parse(loadStatus.getSentTimeStamp().toString().replace(" ", "T")));
		return AdvanceManifestEvent.builder().manifest(Manifest.builder().messageHeader(messageHeader)
				.advanceManifest(advanceManifest).build()).build();
	}

	@Override
	public Result handle(EventToHandlerMapper handlerMapper) {
		EventHandler eventHandler = handlerMapper.map(this);
		return eventHandler.handle(this);
	}	
	
}
