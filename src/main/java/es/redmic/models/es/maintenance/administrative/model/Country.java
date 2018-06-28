package es.redmic.models.es.maintenance.administrative.model;

import es.redmic.models.es.common.model.DomainES;

public class Country extends DomainES {

	private String code;

	public Country() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}