package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(collection = "compliance")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplianceRequest {
	
	private String tpDocumentNo;	
	private List<Routes> routes;
	
}
