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
public class RotationDetails {
	
	@JsonProperty("RotationId")
	private String rotationId;
	
	@JsonProperty("RotationName")
	private String rotationName;
	
	@JsonProperty("RotationVersion")
	private String rotationVersion;

}
