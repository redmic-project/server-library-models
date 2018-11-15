package es.redmic.models.es.common.deserializer;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import es.redmic.exception.databinding.DateTimeDeserializerException;

public class CustomDateTimeDeserializer extends JsonDeserializer<DateTime> {

	final String pattern = "ISO8601";

	@Override
	public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) {

		String dateTime;

		try {
			dateTime = jp.getText();
		} catch (IOException e) {
			throw new DateTimeDeserializerException(pattern, null, e);
		}

		try {

			return DateTime.parse(dateTime).toDateTime(DateTimeZone.UTC);
		} catch (Exception e) {

			throw new DateTimeDeserializerException(pattern, dateTime, e);
		}

	}
}