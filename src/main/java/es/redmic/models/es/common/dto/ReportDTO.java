package es.redmic.models.es.common.dto;

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

public class ReportDTO implements DTOString {

	private String id; // == taskId

	private String titleDefinedByUser;

	@NotNull
	private String selectId;

	@NotNull
	private Long userId;

	@NotNull
	private String taskType;

	private String taskLabel;

	public ReportDTO() {

	}

	public String getTitleDefinedByUser() {
		return titleDefinedByUser;
	}

	public void setTitleDefinedByUser(String titleDefinedByUser) {
		this.titleDefinedByUser = titleDefinedByUser;
	}

	public String getSelectId() {
		return selectId;
	}

	public void setSelectId(String selectId) {
		this.selectId = selectId;
	}

	public Boolean isSelectionId() {
		// TODO: Si cambia la generación de ids de seleccionados en elastic,
		// cambiar esto.
		return selectId.contains("-");
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskLabel() {
		return taskLabel;
	}

	public void setTaskLabel(String taskLabel) {
		this.taskLabel = taskLabel;
	}
}
