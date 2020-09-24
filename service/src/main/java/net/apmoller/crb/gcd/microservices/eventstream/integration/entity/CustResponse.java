package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import java.math.BigInteger;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustResponse {

	
	private String tpDocNbr;
	private String customRefNbr;
	private String dispCode;
	private String sendingCntry;
	private BigInteger itemNbr;
	
	private List<ResponseDetail> responseDetail;
	private Remarks remarks;


	
	
}
