package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransportSchedule {

	@JsonProperty("-xmlns:xsi")
	private String xmlnsXsi;
	
	@JsonProperty("-xsi:noNamespaceSchemaLocation")
	private String xsiNoNamespaceSchemaLocation;
	
	@JsonProperty("MessageHeader")
	private MessageHeader messageHeader;
	
	@JsonProperty("ScheduleEntries")
	private ScheduleEntries scheduleEntries;
}
