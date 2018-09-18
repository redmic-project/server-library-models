package es.redmic.models.es.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:18
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseAbstractStringES implements BaseES<String> {

	private String id;

	public BaseAbstractStringES() {
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}