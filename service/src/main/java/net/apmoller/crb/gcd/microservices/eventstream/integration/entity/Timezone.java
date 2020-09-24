package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import lombok.Data;

@Data
public class Timezone {
	private String cityName;
	private String cityCode;
	private String timezoneCode;
	private String timezoneName;
	private String utcOffsetMins;
}
