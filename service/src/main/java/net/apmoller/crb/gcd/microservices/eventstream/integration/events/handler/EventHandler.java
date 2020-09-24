package net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler;

import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BaseEvent;

public interface EventHandler {
	
	Result handle(BaseEvent baseEvent);
		
}
