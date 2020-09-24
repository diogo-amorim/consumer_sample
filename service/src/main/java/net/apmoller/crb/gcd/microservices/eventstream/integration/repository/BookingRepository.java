package net.apmoller.crb.gcd.microservices.eventstream.integration.repository;

import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.BookingSegment;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BookingRepository extends ReactiveMongoRepository<BookingSegment,String>{
    Mono<Long> countBookingSegmentById_SegmentId(String segmentId);
}