package es.redmic.models.es.administrative.model;

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

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.redmic.models.es.maintenance.administrative.model.ActivityType;
import es.redmic.models.es.maintenance.administrative.model.ThemeInspire;



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

	private List<ActivityResource> resources;

	private ThemeInspire themeInspire;

	private String licence;

	private String normative;

	private String spatialExtension;

	private Boolean starred;

	private ActivityCompact parent;

	private ActivityCompact grandparent;

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

	public List<ActivityResource> getResources() {
		return resources;
	}

	public void setResources(List<ActivityResource> resources) {
		this.resources = resources;
	}

	public ThemeInspire getThemeInspire() {
		return this.themeInspire;
	}

	public void setThemeInspire(ThemeInspire themeInspire) {
		this.themeInspire = themeInspire;
	}

	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public String getNormative() {
		return this.normative;
	}

	public void setNormative(String normative) {
		this.normative = normative;
	}

	public String getSpatialExtension() {
		return this.spatialExtension;
	}

	public void setSpatialExtension(String spatialExtension) {
		this.spatialExtension = spatialExtension;
	}

	public Boolean getStarred() {
		return this.starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	public ActivityCompact getParent() {
		return this.parent;
	}

	public void setParent(ActivityCompact parent) {
		this.parent = parent;
	}

	public ActivityCompact getGrandparent() {
		return this.grandparent;
	}

	public void setGrandparent(ActivityCompact grandparent) {
		this.grandparent = grandparent;
	}
}
