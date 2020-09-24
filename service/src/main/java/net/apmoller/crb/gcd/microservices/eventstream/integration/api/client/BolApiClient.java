package net.apmoller.crb.gcd.microservices.eventstream.integration.api.client;

import com.apmoller.gcd.gcdcommoncomponents.dtos.BillOfLading;

import reactor.core.publisher.Mono;

public interface BolApiClient {
	Mono<BillOfLading> getBillOfLading(String id);
}
