package es.redmic.models.es.geodata.genomics.model;

import es.redmic.models.es.administrative.model.OrganisationCompact;
import es.redmic.models.es.geodata.common.model.ElementsCommonFields;

public class Molecular extends ElementsCommonFields {

	private String description;
	
	private String geoBankCode;
	
	private OrganisationCompact organisation;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGeoBankCode() {
		return geoBankCode;
	}

	public void setGeoBankCode(String geoBankCode) {
		this.geoBankCode = geoBankCode;
	}

	public OrganisationCompact getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompact organisation) {
		this.organisation = organisation;
	}
}
