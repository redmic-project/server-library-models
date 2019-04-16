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

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public class MisidentificationDTO extends MisidentificationCompactDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonSchemaIgnore
	@JsonSerialize(as = TaxonCompactExtendedDTO.class)
	TaxonDTO badIdentity;

	@NotNull
	@Size(min=1)
	List<String> citations;
	
	public TaxonDTO getBadIdentity() {
		return badIdentity;
	}

	public void setBadIdentity(TaxonDTO badIdentity) {
		this.badIdentity = badIdentity;
	}
	
	public List<String> getCitations() {
		return citations;
	}

	public void setCitations(List<String> citations) {
		this.citations = citations;
	}
}
