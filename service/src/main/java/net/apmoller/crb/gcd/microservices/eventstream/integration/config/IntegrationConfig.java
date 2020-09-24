package net.apmoller.crb.gcd.microservices.eventstream.integration.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

@Configuration
@ConfigurationProperties(ignoreUnknownFields = true)
@RefreshScope
@Slf4j
@Getter
public class IntegrationConfig {

//    @Value("${enablePerfMonitoring}")
//    private String enablePerfMonitoring;
//
//    public String getEnablePerfMonitoring() {
//        return enablePerfMonitoring;
//    }
//
//    public void setEnablePerfMonitoring(String enablePerfMonitoring) {
//        this.enablePerfMonitoring = enablePerfMonitoring;
//    }

	@Value("${processGcssFeed}")
	private String processGcssFeed;

	@Value("${processGmsFeed}")
	private String processGmsFeed;

	@Value("${processGsisFeed}")
	private String processGsisFeed;

	@Value("${gcd.api.bol.baseurl}")
	private String bolBaseUrl;

	@Value("${integration.timeout}")
	private Integer timeout;

	@Value("${integration.retryCount}")
	private Integer retryCount;

	@Value("${integration.backoff}")
	private Integer backoff;



	@Bean
	@Qualifier("locationWebClient")
	public WebClient locationWebClient() {
		return WebClient.builder().filter(logRequest()).build();
	}

	@Bean
	@Qualifier("complianceWebClient")
	public WebClient complianceWebClient() {
		return WebClient.builder().filter(logRequest()).build();
	}

	@Bean
	@Qualifier("bolWebClient")
	public WebClient bolWebClient() {
		return WebClient.builder().baseUrl(bolBaseUrl).filter(logRequest()).build();
	}

	private static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
			return Mono.just(clientRequest);
		});
	}

	public String setProcessGcssFeed(String processGcssFeed) {
		return this.processGcssFeed = processGcssFeed;
	}

	public String getProcessGcssFeed() {
		return this.processGcssFeed;
	}

	public String setProcessGmsFeed(String processGmsFeed) {
		return this.processGmsFeed = processGmsFeed;
	}

	public String getProcessGmsFeed() {
		return this.processGmsFeed;
	}

	public String setProcessGsisFeed(String processGsisFeed) {
		return this.processGsisFeed = processGsisFeed;
	}

	public String getProcessGsisFeed() {
		return this.processGsisFeed;
	}
}