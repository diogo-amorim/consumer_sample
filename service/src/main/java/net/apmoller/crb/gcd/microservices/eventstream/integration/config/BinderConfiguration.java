package net.apmoller.crb.gcd.microservices.eventstream.integration.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import net.apmoller.crb.gcd.microservices.eventstream.integration.events.listener.IntegrationEventStream;

@Configuration
@EnableBinding(IntegrationEventStream.class)
public class BinderConfiguration {
	
	
}
