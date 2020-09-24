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
public class Vessel {

	@JsonProperty("VesselCode")
	private String vesselCode;
	
	@JsonProperty("IMONumber")
	private String imoNumber;
	
	@JsonProperty("VesselName")
	private String vesselName;
	
	@JsonProperty("VesselOperatorCode")
	private String vesselOperatorCode;
	
	@JsonProperty("VesselFlag")
	private String vesselFlag;
	
	@JsonProperty("VesselCallSign")
	private String vesselCallSign;

}
