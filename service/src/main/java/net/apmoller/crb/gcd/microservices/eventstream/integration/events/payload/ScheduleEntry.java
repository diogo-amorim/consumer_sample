package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.SiteCallStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleEntry {

	@JsonProperty("RotationDetails")
	private RotationDetails rotationDetails;
	
	@JsonProperty("ScheduleEntryID")
	private ScheduleEntryID scheduleEntryID;
	
	@JsonProperty("SiteCallStatus")
	private SiteCallStatus siteCallStatus;
	
	@JsonProperty("Schedule")
	private Schedule schedule;
	
	@JsonProperty("DummyCall")
	private Boolean dummyCall;
	
	@JsonProperty("OmitReason")
	private String omitReason;
	
	@JsonProperty("Actual")
	private Actual actual;
	
	@JsonProperty("Notes")
	private String notes;
	

}
