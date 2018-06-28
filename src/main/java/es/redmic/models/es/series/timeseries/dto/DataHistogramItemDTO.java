package es.redmic.models.es.series.timeseries.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class DataHistogramItemDTO {
	
	private String key_as_string;
	
	private DataHistogramStatsDTO value;

	@JsonProperty("date")
	public String getKey_as_string() {
		return key_as_string;
	}

	@JsonSetter("key_as_string")
	public void setKey_as_string(String key_as_string) {
		this.key_as_string = key_as_string;
	}

	public DataHistogramStatsDTO getValue() {
		return value;
	}

	public void setValue(DataHistogramStatsDTO value) {
		this.value = value;
	}
	
	@JsonIgnore
	public boolean hasData() {
		return (key_as_string.isEmpty() || value == null || (value != null && value.getCount() == 0)) ? false : true;
	}
}
