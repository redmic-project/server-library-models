package es.redmic.models.es.administrative.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.redmic.models.es.maintenance.administrative.model.ActivityType;



/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity extends ActivityBase {

	@JsonProperty("activityType")
	public ActivityType activitytype;
	
	private String activityCategory;

	public Activity() {
		super();
	}

	public ActivityType getActivityType() {
		return activitytype;
	}

	public void setActivityType(ActivityType activityType) {
		this.activitytype = activityType;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}
}