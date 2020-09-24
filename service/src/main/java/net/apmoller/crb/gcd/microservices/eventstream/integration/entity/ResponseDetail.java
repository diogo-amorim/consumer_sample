package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDetail {
	
	private String code;

	private String codeDescription;

	private String type;

	private String itemNbr;

	private String subItemNbr;

	private String subItemNbr2;

	protected String errorReason;

	private String errorReasonDescription;

	private String origAttribValue;

	private List<Remarks> remarks;
	
}
