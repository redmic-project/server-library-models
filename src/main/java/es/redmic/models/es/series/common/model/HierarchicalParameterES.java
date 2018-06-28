package es.redmic.models.es.series.common.model;

import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.model.HierarchicalES;

public class HierarchicalParameterES extends HierarchicalES {

	private String name;

	private String name_en;

	private DomainES parameterType;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_en() {
		return this.name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public DomainES getParameterType() {
		return parameterType;
	}

	public void setParameterType(DomainES parameterType) {
		this.parameterType = parameterType;
	}
}
