package net.apmoller.crb.gcd.microservices.eventstream.integration.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SiteCallStatus {

	SCHEDULED("SCHEDULED"), ACTUALISED("ACTUALISED"), OMITTED("OMITTED"), DELETED("DELETED"),
	ARRIVAL_HAS_BEEN_ACTUALIZED("ARRIVAL HAS BEEN ACTUALIZED"), EMPTY("EMPTY");

	private String value;

	SiteCallStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
