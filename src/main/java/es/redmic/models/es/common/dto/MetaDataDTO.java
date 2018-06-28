package es.redmic.models.es.common.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MetaDataDTO {

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Double score;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Long version;
	
	@JsonInclude(JsonInclude.Include.ALWAYS)
	private Map<String, Object> highlight;
	
	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	public Map<String, Object> getHighlight() {
		return highlight;
	}

	public void setHighlight(Map<String, Object> highlight) {
		this.highlight = highlight;
	}
}
