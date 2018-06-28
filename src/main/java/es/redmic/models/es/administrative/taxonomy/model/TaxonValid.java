package es.redmic.models.es.administrative.taxonomy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxonValid extends TaxonCompact {

	private TaxonAncestorsCompact validAs;

	public TaxonAncestorsCompact getValidAs() {
		return validAs;
	}

	public void setValidAs(TaxonAncestorsCompact validAs) {
		this.validAs = validAs;
	}
}