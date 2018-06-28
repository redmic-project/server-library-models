package es.redmic.models.es.geojson.tracking.animal.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.administrative.taxonomy.dto.AnimalCompactDTO;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.geojson.tracking.common.BaseTrackingPropertiesDTO;

@JsonSchemaNotNull
public class AnimalTrackingPropertiesDTO extends BaseTrackingPropertiesDTO {

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = AnimalCompactDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	private AnimalCompactDTO animal;

	public AnimalCompactDTO getAnimal() {
		return animal;
	}

	public void setAnimal(AnimalCompactDTO animal) {
		this.animal = animal;
	}
}