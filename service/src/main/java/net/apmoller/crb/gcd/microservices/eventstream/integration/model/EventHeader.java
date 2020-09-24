package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.Data;

@Data
public class EventHeader {
	
	private static final String TRACE_ID = "6sde7e81-58ad-4574-bde9-7554967d1a80";
	
	private String id;
	
	private String type;
	
	private String traceId;
	
	private String timeStamp;
	
	
	public EventHeader(){
		this.id = UUID.randomUUID().toString();
		this.timeStamp = ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
		this.traceId = TRACE_ID;		
	}
	
}
