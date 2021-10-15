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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.DomainES;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends ActivityBase {

	private ActivityCompact parent;

	public DomainES projectGroup;

	public ActivityCompact getParent() {
		return this.parent;
	}

	public void setParent(ActivityCompact parent) {
		this.parent = parent;
	}

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
