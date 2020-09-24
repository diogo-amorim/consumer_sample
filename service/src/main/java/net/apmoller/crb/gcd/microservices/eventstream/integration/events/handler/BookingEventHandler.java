package net.apmoller.crb.gcd.microservices.eventstream.integration.events.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.config.IntegrationConfig;
import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.BookingSegment;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.BookingEvent;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.publisher.EventPublisher;
import net.apmoller.crb.gcd.microservices.eventstream.integration.model.Type;
import net.apmoller.crb.gcd.microservices.eventstream.integration.repository.BookingRepository;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;


@Component
@AllArgsConstructor
@Slf4j
public class BookingEventHandler {

    private final BookingRepository bookingRepository;
    private final EventPublisher eventPublisher;
    private final IntegrationConfig integrationConfig;

    public void handleMessage(Message<?> bookingMessage) {
        Integer totalSegments = (Integer) bookingMessage.getHeaders().get("totalSegments");
        Integer segmentIndex = (Integer) bookingMessage.getHeaders().get("segmentIndex");
        String segmentId = new String((byte[]) bookingMessage.getHeaders().get("segmentId"));
        JsonElement actualJson = JsonParser.parseString(new String((byte[]) bookingMessage.getHeaders().get("GDSHeaderJson")));
        JsonObject jObject = actualJson.getAsJsonObject();
        Optional<String> eventType = jObject.entrySet().stream()
                .filter(entry -> entry.getKey().equals("Event"))
                .map(entry -> entry.getValue().getAsString())
                .findFirst();
        Optional<String> reference = jObject.entrySet().stream()
                .filter(entry -> entry.getKey().equals("Reference"))
                .map(entry -> entry.getValue().getAsString())
                .findFirst();
        log.info("EventProcessor>> eventType {} with segmentId {} index {} and totalIndex {}", eventType, segmentId, segmentIndex, totalSegments);
        if (!ObjectUtils.isEmpty(eventType) && EnumUtils.isValidEnum(Type.class, eventType.get())) {
            BookingSegment bookingSegment = BookingSegment.builder()
                    .id(new BookingSegment.CompositeKey(segmentId,segmentIndex))
                    .eventType(eventType.get())
                    .referenceNumber(reference.orElseGet(() -> ""))
                    .createdDate(LocalDateTime.now())
                    .totalSegments(totalSegments)
                    .isProcessed(Boolean.FALSE)
                    .payload((String) bookingMessage.getPayload()).build();
            if (totalSegments > 1) {
                if (segmentIndex == totalSegments - 1) {
                    bookingRepository.save(bookingSegment)
                            .timeout(Duration.ofSeconds(integrationConfig.getTimeout()))
                            .retryBackoff(integrationConfig.getRetryCount(), Duration.ofSeconds(integrationConfig.getBackoff())).block();
                    Long totalNoOfSegments = bookingRepository.countBookingSegmentById_SegmentId(segmentId)
                            .timeout(Duration.ofSeconds(5))
                            .retryBackoff(3, Duration.ofSeconds(5)).block();
                    log.info("segmentListSize : {} , totalSegments : {}", totalNoOfSegments, totalSegments);
                    if (totalNoOfSegments.intValue() == totalSegments) {
                        eventPublisher.publishBookingEvent(MessageBuilder.withPayload(BookingEvent.builder()
                                .segmentId(segmentId)
                                .eventType(eventType.get())
                                .referenceNumber(reference.orElseGet(() -> ""))
                                .totalSegments(totalSegments)
                                .build()).build());
                    }else {
                        log.info("segmentList size does not match for segmentId {} with expected {} and found {}",segmentId,totalSegments,totalNoOfSegments);
                    }
                } else {
                    bookingRepository.save(bookingSegment)
                            .timeout(Duration.ofSeconds(integrationConfig.getTimeout()))
                            .retryBackoff(integrationConfig.getRetryCount(), Duration.ofSeconds(integrationConfig.getBackoff())).block();
                }
            } else {
                bookingRepository.save(bookingSegment)
                        .timeout(Duration.ofSeconds(integrationConfig.getTimeout()))
                        .retryBackoff(integrationConfig.getRetryCount(), Duration.ofSeconds(integrationConfig.getBackoff())).block();
                eventPublisher.publishBookingEvent(MessageBuilder.withPayload(BookingEvent.builder()
                        .segmentId(segmentId)
                        .eventType(eventType.get())
                        .referenceNumber(reference.orElseGet(() -> ""))
                        .totalSegments(totalSegments)
                        .build()).build());
            }
        } else {
            log.info("Ignoring the message as following eventType is not supported : {}", eventType.get());
        }
    }
}
