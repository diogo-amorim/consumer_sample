package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortCalls {
	
	@JsonProperty("PortCall")
	private List<PortCall> portCall;

}
