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
public class ArrivalVoyage {

	@JsonProperty("Voyage")
	private String voyage;
	
	@JsonProperty("Direction")
	private String direction;
	
	@JsonProperty("TransportMode")
	private String transportMode;

}
