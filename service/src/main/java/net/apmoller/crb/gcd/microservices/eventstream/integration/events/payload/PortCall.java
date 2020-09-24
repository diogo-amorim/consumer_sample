package net.apmoller.crb.gcd.microservices.eventstream.integration.events.payload;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.apmoller.crb.gcd.microservices.eventstream.integration.enums.SiteCallStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PortCall {
		
	@Id
	private String gsisKey;
	
	//private int siteOrder;
	
	private String previousSiteCode;

	private String nextSiteCode;
	
	private String vesselCode;
	
	private String vesselOperatorCode;
	
	private String vesselName;
	
	//private String vesselIMOCode;
	
	private String vesselFlagCode;
	
	//private String vesselFlagCountryName;
	
	private String siteRkstCode;

	private String siteName;
	
	//private String siteGeoCode;
	
	private String cityCode;
	
	//private String cityGeoCode;
	
	private String city;
	
   //private String country;
	
	//private String bda;

	private String arrivalVoyageCode;
	
	private String arrivalServiceCode;
	
	private String arrivalDirection;
	
	private String arrivalVoyageTransportMode;

	private String departureVoyageCode;

	private String departureServiceCode;
	
	private String departureDirection;

	private String departureVoyageTransportMode;

	private String actualArrivalDate;
	
	private String actualDepartureDate;

	private String estimatedArrivalDate;

	private String estimatedDepartureDate;

	private String proformaArrivalDate;

	private String proformaDepartureDate;

	private SiteCallStatus siteCallStatus;
		
}


