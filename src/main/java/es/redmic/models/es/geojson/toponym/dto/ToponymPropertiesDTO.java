package es.redmic.models.es.geojson.toponym.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;
import es.redmic.models.es.maintenance.toponym.dto.ToponymTypeDTO;

@JsonSchemaNotNull
@JsonIgnoreProperties(value = { "activityId" })
public class ToponymPropertiesDTO extends PropertiesDTO {

	@NotNull
	@Size(min = 1, max = 250)
	private String name;

	@Size(min = 0, max = 1500)
	private String description;

	private Integer zoomLevel;

	@JsonIgnoreProperties(value = { "_meta" })
	@Valid
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.TOPONYM_TYPE")
	@JsonSchemaDefault(value = "1")
	private ToponymTypeDTO toponymType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

	public ToponymTypeDTO getToponymType() {
		return toponymType;
	}

	public void setToponymType(ToponymTypeDTO toponymType) {
		this.toponymType = toponymType;
	}
}
