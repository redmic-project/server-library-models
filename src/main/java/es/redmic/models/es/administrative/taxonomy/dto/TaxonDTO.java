package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class TaxonDTO extends TaxonWithOutParentDTO {

	public TaxonDTO() {

	}

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = TaxonCompactExtendedDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.TAXONS")
	private TaxonDTO parent;

	public TaxonDTO getParent() {
		return parent;
	}

	public void setParent(TaxonDTO parent) {
		this.parent = parent;
	}
}
