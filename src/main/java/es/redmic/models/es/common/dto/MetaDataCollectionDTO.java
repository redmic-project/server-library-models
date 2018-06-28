package es.redmic.models.es.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MetaDataCollectionDTO {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Double max_score;

	public Double getMax_score() {
		return max_score;
	}

	public void setMax_score(Double max_score) {
		this.max_score = max_score;
	}
}
