package es.redmic.models.es.maintenance.parameter.model;

import es.redmic.models.es.common.model.DomainES;

public class Unit extends DomainES {

	private String acronym;
	
	private DomainES unitType;
	
	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public DomainES getUnitType() {
		return unitType;
	}

	public void setUnitType(DomainES unitType) {
		this.unitType = unitType;
	}
}
