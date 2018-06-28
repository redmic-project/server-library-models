package es.redmic.models.es.administrative.model;

import es.redmic.models.es.common.model.BasePathAbstractES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 13:27:35
 */
public class ActivityCompact extends BasePathAbstractES {

	public ActivityCompact() {
		super();
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}