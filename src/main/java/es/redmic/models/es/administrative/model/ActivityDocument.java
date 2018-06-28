package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.BaseAbstractES;

public class ActivityDocument extends BaseAbstractES {

	private DocumentCompact document;

	public DocumentCompact getDocument() {
		return document;
	}

	public void setDocument(DocumentCompact document) {
		this.document = document;
	}
}
