package es.redmic.models.es.maintenance.statistics.dto;

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

import javax.validation.constraints.Min;

public class AdministrativeStatisticsDTO {

	private ResultDTO program;
	private ResultDTO project;
	private ResultDTO projectOutProgram;
	private ResultDTO activity;
	private ResultDTO activityOutProject;

	@Min(value = 0)
	private Integer organisation;

	@Min(value = 0)
	private Integer platform;

	@Min(value = 0)
	private Integer document;

	public AdministrativeStatisticsDTO() {

	}

	public ResultDTO getProgram() {
		return program;
	}

	public void setProgram(ResultDTO program) {
		this.program = program;
	}

	public ResultDTO getProject() {
		return project;
	}

	public void setProject(ResultDTO project) {
		this.project = project;
	}

	public ResultDTO getActivity() {
		return activity;
	}

	public void setActivity(ResultDTO activity) {
		this.activity = activity;
	}

	public Integer getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Integer organisation) {
		this.organisation = organisation;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getDocument() {
		return document;
	}

	public void setDocument(Integer document) {
		this.document = document;
	}

	public ResultDTO getProjectOutProgram() {
		return projectOutProgram;
	}

	public void setProjectOutProgram(ResultDTO projectOutProgram) {
		this.projectOutProgram = projectOutProgram;
	}

	public ResultDTO getActivityOutProject() {
		return activityOutProject;
	}

	public void setActivityOutProject(ResultDTO activityOutProject) {
		this.activityOutProject = activityOutProject;
	}
}
