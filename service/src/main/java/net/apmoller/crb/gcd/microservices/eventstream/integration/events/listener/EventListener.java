package net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener;

import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.KeySchema;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.LoadStatus;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.Message;

public interface EventListener {
	
/*	void recieveBookingEvent(Message<?> eventMessage) throws Exception;
	
	void recieveEmptyContainerEvent(Message<?> eventMessage) throws Exception;*/

	void recieveAdvanceManifestEvent(Message<?> message) throws Exception;
	
	void recieveDatedScheduleEvent(Message<?> eventMessage) throws Exception;
	

}
