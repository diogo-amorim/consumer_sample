package net.apmoller.crb.gcd.microservices.eventstream.integration.events.publisher;

import lombok.extern.log4j.Log4j2;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener.IntegrationEventStream;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BookingEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.GcdDatedScheduleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@EnableBinding(IntegrationEventStream.class)
public class EventPublisher {

    @Autowired
    private IntegrationEventStream integrationEventStream;

    public boolean publishDatedScheduleEvent(Message<GcdDatedScheduleEvent> event) {
        boolean result = false;
        try {
            result = integrationEventStream.datedscheduleeventoutboundchannel().send(event);
            log.info("publish DatedSchedule to Kafka EventHub ::" + result);
        } catch (Exception ex) {
            log.error("publish DatedSchedule event to Kafka EventHub failed! {}", ex);
            result = false;
        }
        log.info("publishDatedScheduleEvent result ::>> {}", result);
        return result;
    }

    public boolean publishBookingEvent(Message<BookingEvent> event) {
        log.info("Publishing following message to orchestrator : {}", event);
        boolean result = false;
        result = integrationEventStream.gcssoutputchannel().send(event);
        log.info("published GCSS booking event to GCD Kafka EventHub :: {} " + result);
        return result;
    }

}
