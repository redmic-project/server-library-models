package es.redmic.models.es.common.query.dto;

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

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDescription;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonFilter("DataQueryDTO")
@JsonSchemaNotNull
public class DataQueryDTO extends DataAccessibilityQueryDTO {

	public DataQueryDTO() {
		super();
	}

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@JsonSchemaDescription("Obtiene registros de geometrías comprendidas dentro de los límites especificados.")
	@Valid
	private BboxQueryDTO bbox;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private DateLimitsDTO dateLimits;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Boolean starred;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Boolean hasResource;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer resource;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer document;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer contact;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer organisation;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer platform;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer project;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer program;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private Integer status;

	public Boolean queryIsEmpty() {
		return ((getBbox() == null) && (getPostFilter() == null) && (getText() == null));
	}

	public BboxQueryDTO getBbox() {
		return bbox;
	}

	public void setBbox(BboxQueryDTO bbox) {
		this.bbox = bbox;
	}

	public DateLimitsDTO getDateLimits() {
		return dateLimits;
	}

	public void setDateLimits(DateLimitsDTO dateLimits) {
		this.dateLimits = dateLimits;
	}

	public Boolean getStarred() {
		return this.starred;
	}

	public void setStarred(Boolean starred) {
		this.starred = starred;
	}

	public Boolean getHasResource() {
		return this.hasResource;
	}

	public void setHasResource(Boolean hasResource) {
		this.hasResource = hasResource;
	}

	public Integer getResource() {
		return this.resource;
	}

	public void setResource(Integer resource) {
		this.resource = resource;
	}

	public Integer getDocument() {
		return this.document;
	}

	public void setDocument(Integer document) {
		this.document = document;
	}

	public Integer getContact() {
		return this.contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public Integer getOrganisation() {
		return this.organisation;
	}

	public void setOrganisation(Integer organisation) {
		this.organisation = organisation;
	}

	public Integer getPlatform() {
		return this.platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getProject() {
		return this.project;
	}

	public void setProject(Integer project) {
		this.project = project;
	}

	public Integer getProgram() {
		return this.program;
	}

	public void setProgram(Integer program) {
		this.program = program;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
