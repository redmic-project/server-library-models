package es.redmic.models.es.administrative.taxonomy.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class MisidentificationDTO extends MisidentificationCompactDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaIgnore
	@JsonSerialize(as = TaxonCompactExtendedDTO.class)
	TaxonDTO badIdentity;

	@NotNull
	@Size(min=1)
	List<String> citations;
	
	public TaxonDTO getBadIdentity() {
		return badIdentity;
	}

	public void setBadIdentity(TaxonDTO badIdentity) {
		this.badIdentity = badIdentity;
	}
	
	public List<String> getCitations() {
		return citations;
	}

	public void setCitations(List<String> citations) {
		this.citations = citations;
	}
}
