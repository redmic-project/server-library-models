package es.redmic.models.es.administrative.taxonomy.model;

import es.redmic.models.es.common.model.BasePathAbstractES;

public class TaxonBase extends BasePathAbstractES {

	private String scientificName;
	private String authorship;

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificname) {
		this.scientificName = scientificname;
	}
	
	public String getAuthorship() {
		return authorship;
	}

	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}
}
