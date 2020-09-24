package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.apmoller.gcd.gcdcommoncomponents.dtos.BillOfLading;

import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Mono;

@Component
public class BolApiClientImpl implements BolApiClient {

	@Value("${gcd.api.call.retries}")
	private Integer retryCount;

	@Value("${gcd.api.bol.apiEndPoint}")
	private String apiEndPoint;

	@Autowired
	@Qualifier("bolWebClient")
	WebClient bolWebClient;

	@Override
	public Mono<BillOfLading> getBillOfLading(String id) {
		return bolWebClient.get()
				.uri("/" + apiEndPoint + "/" + id)
				.header(IntegrationConstants.X_APP_ID_KEY, IntegrationConstants.X_APP_ID_VALUE)
				.header(IntegrationConstants.X_API_KEY_KEY, IntegrationConstants.X_API_KEY_VALUE)
				.retrieve().bodyToMono(BillOfLading.class)
				.retry(retryCount);
	}

}
