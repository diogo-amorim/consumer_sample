package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@Data
public class BookingSegment {
    @Id
    private CompositeKey id;

    private String referenceNumber;

    private Integer totalSegments;

    @CreatedDate
    private LocalDateTime createdDate;

    private String eventType;

    private Boolean isProcessed;

    private String payload;

    @Value
    @AllArgsConstructor
    public static class CompositeKey implements Serializable {
        @Indexed
        private String segmentId;
        private Integer segmentIndex;
    }
}
