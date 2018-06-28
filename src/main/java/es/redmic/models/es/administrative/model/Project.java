package es.redmic.models.es.administrative.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.DomainES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends ActivityBase {

	public DomainES projectGroup;
	
	public DomainES getProjectGroup() {
		return projectGroup;
	}

	public void setProjectGroup(DomainES projectGroup) {
		this.projectGroup = projectGroup;
	}

	public Project() {
		super();
	}
}