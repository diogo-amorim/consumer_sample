package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import net.apmoller.crb.gcd.microservices.eventstream.integration.entity.Timezone;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Mono;

@Component
public class LocationApiClientImpl implements LocationApiClient {
	@Autowired
	@Qualifier("locationWebClient")
	private WebClient client;

	@Value("${gcd.api.location.timezone.url}")
	private String timezoneUrl;

	@Override
	public Mono<Timezone> getTimezone(String citycode) {
		return client.get()
				.uri(timezoneUrl + "/" + citycode)
				.header(IntegrationConstants.X_APP_ID_KEY, IntegrationConstants.X_APP_ID_VALUE)
				.header(IntegrationConstants.X_API_KEY_KEY, IntegrationConstants.X_API_KEY_VALUE)
				.retrieve().bodyToMono(Timezone.class).retry(3)
				.switchIfEmpty(Mono.empty());
	}


}
