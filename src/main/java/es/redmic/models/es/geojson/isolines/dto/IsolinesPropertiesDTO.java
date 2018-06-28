package es.redmic.models.es.geojson.isolines.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;
import es.redmic.models.es.maintenance.line.dto.LineTypeBaseDTO;
import es.redmic.models.es.maintenance.parameter.dto.DataDefinitionDTO;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.models.es.series.common.dto.HierarchicalParameterDTO;

@JsonSchemaNotNull
public class IsolinesPropertiesDTO extends PropertiesDTO {

	private Double z;

	private Double deviation;

	private Double value;

	private Character qFlag = '0';

	private Character vFlag = 'U';

	@NotNull
	@Valid
	private DataDefinitionDTO dataDefinition;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSchemaUrl(value = "controller.mapping.UNIT")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private UnitDTO unit;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSchemaUrl(value = "controller.mapping.PARAMETER")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private HierarchicalParameterDTO parameter;

	@JsonIgnoreProperties(value = { "_meta", "leaves" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.LINE_TYPE")
	private LineTypeBaseDTO lineType;

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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@JsonProperty(value = "qFlag")
	public Character getQFlag() {
		return qFlag;
	}

	@JsonProperty(value = "qFlag")
	public void setQFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonIgnore
	public void setqFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonProperty(value = "vFlag")
	public Character getVFlag() {
		return vFlag;
	}

	@JsonProperty(value = "vFlag")
	public void setVFlag(Character vFlag) {
		this.vFlag = vFlag;
	}

	@JsonIgnore
	public void setvFlag(Character vFlag) {
		this.vFlag = vFlag;
	}

	public LineTypeBaseDTO getLineType() {
		return lineType;
	}

	public void setLineType(LineTypeBaseDTO lineType) {
		this.lineType = lineType;
	}

	public DataDefinitionDTO getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinitionDTO dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public HierarchicalParameterDTO getParameter() {
		return parameter;
	}

	public void setParameter(HierarchicalParameterDTO parameter) {
		this.parameter = parameter;
	}

	public UnitDTO getUnit() {
		return unit;
	}

	public void setUnit(UnitDTO unit) {
		this.unit = unit;
	}
}
