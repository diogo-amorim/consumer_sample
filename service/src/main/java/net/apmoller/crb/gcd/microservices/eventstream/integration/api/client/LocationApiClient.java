package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.Timezone;
import reactor.core.publisher.Mono;

public interface LocationApiClient {
	public Mono<Timezone> getTimezone(String citycode);
}
