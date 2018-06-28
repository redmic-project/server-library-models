package es.redmic.models.es.series.attributeseries.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.qualifiers.model.AttributeTypeBase;
import es.redmic.models.es.series.common.model.SeriesCommon;

public class AttributeSeries extends SeriesCommon {

	private DateTime startDate;
	
	private DateTime endDate;
	
	private AttributeTypeBase attributeType;
	
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
	
	public AttributeTypeBase getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeTypeBase attributeType) {
		this.attributeType = attributeType;
	}
}
