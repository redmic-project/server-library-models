package es.redmic.models.es.geojson.base;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

	private String activity;

	private DateTime inserted;

	private DateTime updated;

	public Properties() {
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getInserted() {
		return inserted;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getUpdated() {
		return updated;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}
}