package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Schedule {

	@JsonProperty("ProformaArrival")
	private String proformaArrival;
	
	@JsonProperty("ProformaDeparture")
	private String proformaDeparture;
	
	@JsonProperty("ScheduledArrival")
	private String scheduledArrival;
	
	@JsonProperty("ScheduledDeparture")
	private String scheduledDeparture;
	
	
}
