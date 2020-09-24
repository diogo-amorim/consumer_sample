package net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifestEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.DatedScheduleEvent;

@Component
public class EventToHandlerMapper {

	@Autowired
	private DatedScheduleEventHandler datedScheduleEventHandler;

	@Autowired
	private AdvanceManifestEventHandler advanceManifestEventHandler;

	public EventHandler map(DatedScheduleEvent datedScheduleEvent) {
		return datedScheduleEventHandler;
	}

	public EventHandler map(AdvanceManifestEvent advanceManifestEvent) {
		return advanceManifestEventHandler;
	}


}
