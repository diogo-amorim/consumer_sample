package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.ComplianceLoadStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvanceManifest {

	@JsonProperty("transportDocumentNumber")
	private String transportDocumentNumber;

	@JsonProperty("vesselCode")
	private String vesselCode;
	
	@JsonProperty("arrivalVoyageNumber")
	private String arrivalVoyageNumber;
	
	@JsonProperty("complianceReceiverPort")
	private String complianceReceiverPort;

	@JsonProperty("mrnCustomsNumber")
	private String mrnCustomsNumber;
		
	@JsonProperty("departureVoyageNumber")
	private String departureVoyageNumber;
	
	@JsonProperty("loadPort")
	private String loadPort;
	
	@JsonProperty("dischargePort")
	private String dischargePort;
	
	@JsonProperty("complianceStatus")
	private String complianceStatus;
	
	@JsonProperty("complianceLoadStatus")
	private String complianceLoadStatus;
	
	@JsonProperty("customsResponseReason")
	private String customsResponseReason;
	
	@JsonProperty("sentTimeStamp")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime sentTimeStamp;
	
	@JsonProperty("entryPortETA")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime entryPortEta;
	
	@JsonProperty("containerNumbers")
	private List<String> containerNumbers;
}