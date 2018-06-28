package es.redmic.models.es.geojson.tracking.platform.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.administrative.dto.PlatformCompactDTO;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.tracking.common.BaseTrackingPropertiesDTO;

@JsonSchemaNotNull
public class PlatformTrackingPropertiesDTO extends BaseTrackingPropertiesDTO {

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = PlatformCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	private PlatformCompactDTO platform;

	public PlatformCompactDTO getPlatform() {
		return platform;
	}

	public void setPlatform(PlatformCompactDTO platform) {
		this.platform = platform;
	}

}