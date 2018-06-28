package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.DomainES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 13:22:45
 */
public class AncestorActivity extends ActivityCompact {

	private DomainES rank;

	public DomainES getRank() {
		return rank;
	}

	public void setRank(DomainES rank) {
		this.rank = rank;
	}

}