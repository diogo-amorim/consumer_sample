package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.Result;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler.EventToHandlerMapper;

public abstract class BaseEvent {
	
	public abstract Result handle(EventToHandlerMapper mapper);
	

}
