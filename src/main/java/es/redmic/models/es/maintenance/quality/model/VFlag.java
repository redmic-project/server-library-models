package es.redmic.models.es.maintenance.quality.model;

import java.io.Serializable;

import es.redmic.models.es.common.model.BaseAbstractStringES;

public class VFlag extends BaseAbstractStringES implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private String name_en;

	public VFlag() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
}