package net.apmoller.crb.gcd.microservices.eventstream.integration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dates {
	
	private String dateTime;
	private String dateTimeKind;

}
