package es.redmic.models.es.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:19
 */
public class DomainES extends Compact {

	@JsonProperty("name_en")
	private String name_en;

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

}