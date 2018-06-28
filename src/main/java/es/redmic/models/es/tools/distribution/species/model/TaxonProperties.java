package es.redmic.models.es.tools.distribution.species.model;

import java.util.List;

import es.redmic.models.es.tools.distribution.model.Properties;

public class TaxonProperties extends Properties{

	private List<TaxonDistribution> taxons;

	public List<TaxonDistribution> getTaxons() {
		return taxons;
	}

	public void setTaxons(List<TaxonDistribution> taxons) {
		this.taxons = taxons;
	}
	
}