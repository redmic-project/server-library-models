package es.redmic.models.es.administrative.taxonomy.model;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2024 REDMIC Project / Server
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

import es.redmic.models.es.common.model.UuidModel;

public class AnimalTaxonomyCompact extends UuidModel {

	private String name;

	private Long taxonid;

	private Long taxononomyid;

	private String photo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTaxonid() {
		return taxonid;
	}

	public void setTaxonid(Long taxonid) {
		this.taxonid = taxonid;
	}

	public Long getTaxononomyid() {
		return taxononomyid;
	}

	public void setTaxononomyid(Long taxononomyid) {
		this.taxononomyid = taxononomyid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
