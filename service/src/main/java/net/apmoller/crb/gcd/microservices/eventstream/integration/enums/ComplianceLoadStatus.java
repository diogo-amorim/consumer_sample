package net.apmoller.crb.gcd.microservices.eventstream.integration.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ComplianceLoadStatus {
	
	    LOAD_OK("OK"),
	    LOAD_NOT_OK("Not OK");

	    private String value;

	    ComplianceLoadStatus(String value) {
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
