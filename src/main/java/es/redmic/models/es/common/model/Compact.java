package es.redmic.models.es.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:19:22
 */
public class Compact extends BaseAbstractES {

	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}