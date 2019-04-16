package es.redmic.models.es.administrative.taxonomy.model;

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

import es.redmic.models.es.common.model.BasePathAbstractES;

public class TaxonBase extends BasePathAbstractES {

	private String scientificName;
	private String authorship;

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
}
