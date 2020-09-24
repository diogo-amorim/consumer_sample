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
public class NextPortCall {

	@JsonProperty("CityCode")
	private String cityCode;

	@JsonProperty("TerminalCode")
	private String terminalCode;

	@JsonProperty("CityName")
	private String cityName;

	@JsonProperty("TerminalName")
	private String terminalName;

	@JsonProperty("GeoCode")
	private String geoCode;

}
