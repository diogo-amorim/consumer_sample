package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload.AdvanceManifest;
import reactor.core.publisher.Mono;

public interface ComplianceApiClient {

	Mono<AdvanceManifest>  callComplianceApiByManifest(AdvanceManifest advanceManifestRequest);

}
