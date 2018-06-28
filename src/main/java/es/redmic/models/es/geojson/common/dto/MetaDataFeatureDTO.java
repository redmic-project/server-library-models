package es.redmic.models.es.geojson.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import es.redmic.models.es.common.dto.MetaDataDTO;

public class MetaDataFeatureDTO extends MetaDataDTO {
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}