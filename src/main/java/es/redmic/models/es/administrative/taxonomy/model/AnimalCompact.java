package es.redmic.models.es.administrative.taxonomy.model;

import es.redmic.models.es.common.model.UuidModel;

public class AnimalCompact extends UuidModel {

	private String name;
	
	private TaxonValid taxon;
	
	private String photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TaxonValid getTaxon() {
		return taxon;
	}

	public void setTaxon(TaxonValid taxon) {
		this.taxon = taxon;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
