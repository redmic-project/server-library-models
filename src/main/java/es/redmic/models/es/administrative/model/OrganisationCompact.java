package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.BaseAbstractES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:18:10
 */
public class OrganisationCompact extends BaseAbstractES {

	private String logo;
	private String acronym;
	private String name;

	public OrganisationCompact() {
		super();
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}