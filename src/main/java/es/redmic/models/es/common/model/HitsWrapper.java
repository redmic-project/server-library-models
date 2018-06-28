package es.redmic.models.es.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HitsWrapper {
	
	private int total;
	
	private Double max_score;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Double getMax_score() {
		return max_score;
	}

	public void setMax_score(Double max_score) {
		this.max_score = max_score;
	}
}
