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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonFilter("DataQueryDTO")
@JsonSchemaNotNull
public class DataAccessibilityQueryDTO extends MetadataQueryDTO {

	public DataAccessibilityQueryDTO() {
		super();
	}

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private String activityId;

	@JsonView(value = { JsonViewsForQueryDTO.Administrator.class })
	@Size(max = 4)
	@JsonSchemaDefault("[2]")
	private List<Long> accessibilityIds;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public List<Long> getAccessibilityIds() {
		return accessibilityIds;
	}

	public void setAccessibilityIds(List<Long> accessibilityIds) {
		this.accessibilityIds = accessibilityIds;
	}

	@Override
	public void addAccessibilityIds(List<Long> accessibilityIds) {

		if (accessibilityIds != null && accessibilityIds.size() > 0) {

			if (this.accessibilityIds == null)
				this.accessibilityIds = new ArrayList<Long>();

			this.accessibilityIds.addAll(accessibilityIds);
		}
	}
}
