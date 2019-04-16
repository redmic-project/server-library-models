package es.redmic.models.es.administrative.taxonomy.dto;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.dto.DTOImplementWithMeta;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxonCompactExtendedDTO extends DTOImplementWithMeta {

	@NotNull
	@Size(min = 1, max = 150)
	private String scientificName;

	@Size(min = 0, max = 200)
	private String authorship;

	@JsonSchemaIgnore
	private String path;

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificname) {
		this.scientificName = scientificname;
	}

	public String getAuthorship() {
		return authorship;
	}

	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonIgnore
	public String getCompactName() {
		String compactName = scientificName;
		if (authorship != null)
			compactName+= " " + authorship;
		return compactName;
	}
}
