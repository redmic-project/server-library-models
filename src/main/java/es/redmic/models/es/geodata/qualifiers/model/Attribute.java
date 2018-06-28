package es.redmic.models.es.geodata.qualifiers.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.qualifiers.model.AttributeType;

public class Attribute extends BaseAbstractES {

	private DateTime startDate;
	
	private DateTime endDate;
	
	private Character qFlag = '0';

	private Character vFlag = 'U';
	
	private String remark;
	
	private AttributeType attributeType;

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

	@JsonProperty(value="qFlag")
	public Character getQFlag() {
		return qFlag;
	}

	public void setQFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonProperty(value="vFlag")
	public Character getVFlag() {
		return vFlag;
	}

	public void setVFlag(Character vFlag) {
		this.vFlag = vFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(AttributeType attributeType) {
		this.attributeType = attributeType;
	}
}
