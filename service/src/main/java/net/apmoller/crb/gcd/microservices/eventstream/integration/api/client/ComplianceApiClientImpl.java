package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifest;
import net.apmoller.crb.gcd.microservices.eventstream.integration.exception.ManifestDataException;
import net.apmoller.crb.gcd.microservices.eventstream.integration.util.IntegrationConstants;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class ComplianceApiClientImpl implements ComplianceApiClient {

	@Value("${gcd.api.compliance.baseurl}")
	private String complianceBaseUrl;

	@Value("${gcd.api.compliance.manifesturi}")
	private String manifestUri;

	@Value("${gcd.api.call.retries}")
	private Integer retryCount;

	@Autowired
	@Qualifier("complianceWebClient")
	WebClient webClient;
	
	@Autowired
	WebClient.Builder webClientBuilder;

	@PostConstruct
	public void initialize() {
		webClient = webClientBuilder.baseUrl(complianceBaseUrl).build();
	}

	@Override
	public Mono<AdvanceManifest> callComplianceApiByManifest(AdvanceManifest advanceManifestRequest) {
		log.info("ComplianceApiClientImpl-> callComplianceApiByManifest request passed >> "+advanceManifestRequest.toString());
		Mono<AdvanceManifest> manifestResponse = webClient.post().uri(manifestUri)
				.headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
				.header(IntegrationConstants.X_APP_ID_KEY, IntegrationConstants.X_APP_ID_VALUE)
				.header(IntegrationConstants.X_API_KEY_KEY, IntegrationConstants.X_API_KEY_VALUE)
//				.bodyValue(advanceManifestRequest)
				.body(Mono.just(advanceManifestRequest), AdvanceManifest.class)
				.retrieve()
				.bodyToMono(AdvanceManifest.class)
				.retry(retryCount)
				.log("Invoke Compliance API for TpDocNumber :" + advanceManifestRequest.getTransportDocumentNumber())
				.doOnError(error->Mono.error(new ManifestDataException(HttpStatus.INTERNAL_SERVER_ERROR,
						"problem while invoking Compliance Api", error)));
		return manifestResponse;
	}
}
