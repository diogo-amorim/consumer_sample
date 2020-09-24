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
public class ScheduleEntryIdentifier {
	
	@JsonProperty("Vessel")
	private Vessel vessel;
	
	@JsonProperty("ArrivalVoyage")
	private ArrivalVoyage arrivalVoyage;
	
	@JsonProperty("DepartureVoyage")
	private DepartureVoyage departureVoyage;
	
	@JsonProperty("Service")
	private Service service;
	
	@JsonProperty("PreviousPortCall")
	private PreviousPortCall previousPortCall;
	
	@JsonProperty("CurrentPortCall")
	private CurrentPortCall currentPortCall;
	
	@JsonProperty("NextPortCall")
	private NextPortCall nextPortCall;

}
