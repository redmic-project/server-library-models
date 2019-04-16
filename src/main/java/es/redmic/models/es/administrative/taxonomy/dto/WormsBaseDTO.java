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

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WormsBaseDTO {

	@NotNull
	private Integer aphia;

	@NotNull
	@Size(min = 1, max = 150)
	private String scientificname;

	@Size(min = 0, max = 150)
	private String rank;

	@JsonGetter("AphiaID")
	public Integer getAphia() {
		return aphia;
	}

	@JsonSetter("AphiaID")
	public void setAphia(Integer aphia) {
		this.aphia = aphia;
	}

	public String getScientificname() {
		return scientificname;
	}

	public void setScientificname(String scientificname) {
		this.scientificname = scientificname;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
