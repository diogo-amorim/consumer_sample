package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageHeader {

	@JsonProperty("Environment")
	private String environment;
	
	@JsonProperty("SourceId")
    private String sourceId;
	
	@JsonProperty("MessageGeneratedTimestamp")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private DateTime messageGeneratedTimestamp;
	
	@JsonProperty("EventName")
	private String eventName;
	
	@JsonProperty("MessageId")
	private String messageId;
	
	@JsonProperty("CorrelationId")
	private String correlationId;
	
	@JsonProperty("CausationId")
	private String causationId;
	
	@JsonProperty("MessageExpirationDateTime")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private DateTime messageExpDateTime;
		
	@JsonProperty("TraceId")
	private String traceId;
	
	
}
