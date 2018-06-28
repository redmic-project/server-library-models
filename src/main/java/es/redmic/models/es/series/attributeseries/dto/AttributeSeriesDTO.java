package es.redmic.models.es.series.attributeseries.dto;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.qualifiers.dto.AttributeTypeBaseDTO;
import es.redmic.models.es.series.common.dto.SeriesCommonDTO;

public class AttributeSeriesDTO extends SeriesCommonDTO {

	private DateTime startDate;

	private DateTime endDate;

	@NotNull
	@JsonIgnoreProperties(value = { "_meta", "leaves" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ATTRIBUTE_TYPE")
	AttributeTypeBaseDTO attributeType;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public AttributeTypeBaseDTO getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeTypeBaseDTO attributeType) {
		this.attributeType = attributeType;
	}

	@JsonIgnore
	public String get_parentId() {
		return super.get_parentId();
	}

	@JsonIgnore
	public String get_grandparentId() {
		return super.get_grandparentId();
	}
}
