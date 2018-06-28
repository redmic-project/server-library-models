package es.redmic.models.es.maintenance.administrative.model;

import es.redmic.models.es.common.model.DomainES;

public class ActivityTypeCompact extends DomainES {

	private DomainES activityField;

	public DomainES getActivityField() {
		return activityField;
	}

	public void setActivityField(DomainES activityField) {
		this.activityField = activityField;
	}
}