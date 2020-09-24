package net.apmoller.crb.gcd.microservices.eventstream.integration.util;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class CustomDateDeserializer implements JsonDeserializer<Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	public Date deserialize(JsonElement dateStr, Type typeOfT, JsonDeserializationContext context) {
		try {
			return dateFormat.parse(dateStr.getAsString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
