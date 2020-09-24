package net.apmoller.crb.gcd.microservices.eventstream.integration.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, Date>{

	private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 

	public Date unmarshal(String xml) throws Exception {
        return dateFormat.parse(xml);
	}

	public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
	}

}
