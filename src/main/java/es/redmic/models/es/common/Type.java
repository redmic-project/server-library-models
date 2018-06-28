package es.redmic.models.es.common;

import java.util.ArrayList;
import java.util.List;

public final class Type {
	
	private String activityCategory;
	
	private List<Long> activityTypes;
	
	public Type(String activityCategory) {
		this.activityCategory = activityCategory;
	}
	
	public Type(String activityCategory, Long activityTypeId) {
		
		this.activityCategory = activityCategory;
		activityTypes = new ArrayList<Long>();
		activityTypes.add(activityTypeId);
	}
	
	public Type(String activityCategory, List<Long> activityTypeIds) {
		
		this.activityCategory = activityCategory;
		this.activityTypes = activityTypeIds;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}

	public List<Long> getActivityTypes() {
		return activityTypes;
	}

	public void setActivityTypes(List<Long> activityTypes) {
		this.activityTypes = activityTypes;
	}
}
