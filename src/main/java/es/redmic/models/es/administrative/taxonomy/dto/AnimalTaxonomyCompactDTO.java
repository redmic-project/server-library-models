package es.redmic.models.es.administrative.taxonomy.dto;

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

import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.UuidDTO;

public class AnimalTaxonomyCompactDTO extends UuidDTO {

	private Long taxonid;

	private Long taxonomyid;

	@Size(min = 0, max = 250)
	private String photo;

	public Long getTaxonid() {
		return taxonid;
	}

	public void setTaxonid(Long taxonid) {
		this.taxonid = taxonid;
	}

	public Long getTaxonomyid() {
		return taxonomyid;
	}

	public void setTaxonomyid(Long taxonomyid) {
		this.taxonomyid = taxonomyid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Size(min = 1, max = 50)
	@Override
	public String getName() {
		return name;
	}
}
