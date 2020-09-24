package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LodgementStatusResponse {
	
	private String responseSenderReference;

	private String responseReceiverReference;

	private String senderInfo;

	private String lodgementStatus;

	private String lodgementStatusDescription;
	
	private List<Dates> dates;

}
