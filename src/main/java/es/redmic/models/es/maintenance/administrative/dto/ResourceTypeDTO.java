package es.redmic.models.es.maintenance.administrative.dto;

import javax.validation.constraints.Size;

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

import es.redmic.models.es.common.dto.DomainImplDTO;

public class ResourceTypeDTO extends DomainImplDTO {

	@Size(min = 0, max = 1500)
	private String description;

	public ResourceTypeDTO() {
		super();
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}