package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actual {

	@JsonProperty("ActualArrival")
	private String actualArrivalDate;
	
	@JsonProperty("ActualDeparture")
	private String actualDepartureDate;
	
	@JsonProperty("ArrivalAtPilotStation")
	private String arrivalAtPilotStation;
	
	@JsonProperty("FirstPilotOnBoard")
	private String firstPilotOnBoard;
	
	@JsonProperty("PilotOff")
	private String pilotOff;

}
