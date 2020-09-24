package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookingEvent {
    private String segmentId;
    private String eventType;
    private String referenceNumber;
    private Integer totalSegments;

}
