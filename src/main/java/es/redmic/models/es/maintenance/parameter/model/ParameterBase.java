package es.redmic.models.es.maintenance.parameter.model;

import es.redmic.models.es.common.model.DomainES;

public class ParameterBase extends DomainES {

	private DomainES parameterType;

	public DomainES getParameterType() {
		return parameterType;
	}

	public void setParameterType(DomainES parameterType) {
		this.parameterType = parameterType;
	}
}