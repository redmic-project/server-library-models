package es.redmic.models.es.series.common.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class SeriesBase extends SeriesCommon {
	
	private Double z;
	
	private Double deviation;

	private double value;
	
	private DateTime date;
	
	private Long dataDefinition;
	
	public Double getZ() {
		return z;
	}
	
	public void setZ(Double z) {
		this.z = z;
	}
	
	public Double getDeviation() {
		return deviation;
	}
	
	public void setDeviation(Double deviation) {
		this.deviation = deviation;
	}
	
	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getDate() {
		return date;
	}
	
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setDate(DateTime date) {
		this.date = date;
	}

	public Long getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(Long dataDefinition) {
		this.dataDefinition = dataDefinition;
	}
}
