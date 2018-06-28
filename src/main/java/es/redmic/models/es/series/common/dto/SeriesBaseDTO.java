package es.redmic.models.es.series.common.dto;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class SeriesBaseDTO extends SeriesCommonDTO {
	
	@NotNull
	private Double value;
	
	@NotNull
	private DateTime date;

	private Long dataDefinition;
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
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
