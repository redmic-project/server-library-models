package es.redmic.models.es.geodata.ancillarydata.model;

import es.redmic.models.es.administrative.model.OrganisationCompact;
import es.redmic.models.es.geodata.common.model.ElementsCommonFields;
import es.redmic.models.es.maintenance.parameter.model.DataDefinition;
import es.redmic.models.es.maintenance.parameter.model.ParameterBase;
import es.redmic.models.es.maintenance.parameter.model.Unit;

public class Analytic extends ElementsCommonFields {
	
	private Double value;

	private OrganisationCompact organisation;
	
	private DataDefinition dataDefinition;
	
	private ParameterBase parameter;
	
	private Unit unit;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public OrganisationCompact getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompact organisation) {
		this.organisation = organisation;
	}

	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public ParameterBase getParameter() {
		return parameter;
	}

	public void setParameter(ParameterBase parameter) {
		this.parameter = parameter;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
