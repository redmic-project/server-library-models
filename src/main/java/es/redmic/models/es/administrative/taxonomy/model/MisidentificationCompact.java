package es.redmic.models.es.administrative.taxonomy.model;

import es.redmic.models.es.administrative.model.DocumentCompact;
import es.redmic.models.es.common.model.BaseAbstractES;

public class MisidentificationCompact extends BaseAbstractES {

	DocumentCompact document;
	
	TaxonAncestorsCompact taxon;
	
	String note;

	public DocumentCompact getDocument() {
		return document;
	}

	public void setDocument(DocumentCompact document) {
		this.document = document;
	}

	public TaxonAncestorsCompact getTaxon() {
		return taxon;
	}

	public void setTaxon(TaxonAncestorsCompact taxon) {
		this.taxon = taxon;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
