package es.redmic.models.es.series.common.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;

@JsonSchemaNotNull
public class MeasurementDTO {
	
	@NotNull
	@Valid
	private DataDefinitionSeriesDTO dataDefinition;
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaUrl(value="controller.mapping.UNIT")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private UnitDTO unit;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaUrl(value="controller.mapping.PARAMETER")
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@NotNull
	private HierarchicalParameterDTO parameter;
	
	// TODO: cambiar object por dto específico cuando se de el caso.
	@JsonInclude(Include.NON_NULL)
	@JsonSchemaIgnore
	private List<Object> data;

	public DataDefinitionSeriesDTO getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinitionSeriesDTO dataDefinition) {
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

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}
}