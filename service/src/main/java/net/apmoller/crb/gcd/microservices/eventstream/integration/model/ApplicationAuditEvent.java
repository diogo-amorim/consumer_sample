package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ApplicationAuditEvent {
	
    private String tpDocumentNo;
	
	private String previousValues;

	private String currentValues;
	

}
