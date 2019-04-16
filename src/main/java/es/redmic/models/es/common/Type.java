package es.redmic.models.es.common;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
