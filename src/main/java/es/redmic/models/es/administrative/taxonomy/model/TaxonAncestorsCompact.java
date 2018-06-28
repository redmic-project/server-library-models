package es.redmic.models.es.administrative.taxonomy.model;

import es.redmic.models.es.common.model.DomainES;

public class TaxonAncestorsCompact extends TaxonBase {

	private DomainES rank;

	public DomainES getRank() {
		return rank;
	}

	public void setRank(DomainES rank) {
		this.rank = rank;
	}
}
