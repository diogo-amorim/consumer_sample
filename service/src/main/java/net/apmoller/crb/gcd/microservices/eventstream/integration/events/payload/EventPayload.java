package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventPayload {
	
	private String message;
    private String msgtimeStamp;
    
}
