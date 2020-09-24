package net.apmoller.crb.gcd.microservices.eventstream.integration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ManifestDataException extends ResponseStatusException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManifestDataException(HttpStatus status, String message, Throwable ex) {
		super(status, message, ex);
	}

	public ManifestDataException(HttpStatus status, String message) {
		super(status, message);
	}

}
