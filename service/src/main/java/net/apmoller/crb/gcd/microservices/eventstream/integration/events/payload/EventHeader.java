package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventHeader {
	
	private String sourceId; 
	
	private DateTime messageGeneratedTimestamp;
	
	private String eventType;
	
	private String messageId;
	
	private String correlationId; 
	
	private String traceId;
			
	private String integrationSentTimestamp;
	
	
	public EventHeader(String sourceId, DateTime msgGeneratedTimestamp, String eventType, String messageId,  String correlationId, String traceId){
		this.sourceId = sourceId;
		this.messageGeneratedTimestamp= msgGeneratedTimestamp;
		this.eventType = eventType;
		this.messageId= messageId;
		this.correlationId= correlationId;
		this.traceId= traceId;
		this.integrationSentTimestamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
	}
}
