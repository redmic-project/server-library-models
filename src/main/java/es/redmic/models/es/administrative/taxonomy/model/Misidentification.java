package es.redmic.models.es.administrative.taxonomy.model;

public class Misidentification extends MisidentificationCompact {
	
	TaxonAncestorsCompact badIdentity;

	public TaxonAncestorsCompact getBadIdentity() {
		return badIdentity;
	}

	public void setBadIdentity(TaxonAncestorsCompact badIdentity) {
		this.badIdentity = badIdentity;
	}
}
