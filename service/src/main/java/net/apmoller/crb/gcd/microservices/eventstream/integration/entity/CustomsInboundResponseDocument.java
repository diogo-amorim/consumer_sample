package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customsinbound")
public class CustomsInboundResponseDocument {

	private String sourceID;
	
	@Id
	private String evwRef;
	
	private String iChgCtrl;
	private String vesselCode;
	private String loadPort;
	private String exportVoyage;
	private String dischargePort;
	private String dischargeVoyage;

	private String sentTS;
	private String recdTS;
	
	private LodgementStatusResponse lodgementStatusResponse;
	private List<CustResponse> custResponse;
	

	
	
}
