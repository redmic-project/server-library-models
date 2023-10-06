package es.redmic.models.es.administrative.dto;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.administrative.dto.ActivityTypeDTO;
import es.redmic.models.es.maintenance.administrative.dto.ThemeInspireDTO;

public class ActivityDTO extends ActivityBaseDTO {

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonSerialize(as = AncestorActivityDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.PROJECT")
	private AncestorActivityDTO parent;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = AncestorActivityDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaIgnore
	private AncestorActivityDTO grandparent;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.ACTIVITY_TYPE")
	private ActivityTypeDTO activityType;

	@JsonSchemaIgnore
	private String activityCategory;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ActivityResourceDTO> resources;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<ActivityEmbeddedContentDTO> embeddedContents;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.THEME_INSPIRE")
	private ThemeInspireDTO themeInspire;

	@Size(max = 5000)
	private String licence;

	@Size(max = 5000)
	private String normative;

	private String spatialExtension;

	private Boolean starred;

	public ActivityDTO() {
		super();
		this.resources = new ArrayList<>();
	}

	public AncestorActivityDTO getParent() {
		return parent;
	}

	public void setParent(AncestorActivityDTO parent) {
		this.parent = parent;
	}

	public AncestorActivityDTO getGrandparent() {
		return this.grandparent;
	}

	public void setGrandparent(AncestorActivityDTO grandparent) {
		this.grandparent = grandparent;
	}

	public ActivityTypeDTO getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityTypeDTO activityType) {
		this.activityType = activityType;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}

	public List<ActivityResourceDTO> getResources() {
		return this.resources;
	}

	public void setResources(List<ActivityResourceDTO> resources) {
		this.resources = resources;
	}

	public List<ActivityEmbeddedContentDTO> getEmbeddedContents() {
		return this.embeddedContents;
	}

	public void setEmbeddedContents(List<ActivityEmbeddedContentDTO> embeddedContents) {
		this.embeddedContents = embeddedContents;
	}

	public ThemeInspireDTO getThemeInspire() {
		return this.themeInspire;
	}

	public void setThemeInspire(ThemeInspireDTO themeInspire) {
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
}
