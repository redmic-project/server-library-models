package es.redmic.models.es.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 11:55:18
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public abstract class BaseAbstractES implements BaseES<Long> {

	private Long id;

	public BaseAbstractES() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}