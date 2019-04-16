package es.redmic.models.es.tools.distribution.species.model;

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

import es.redmic.models.es.common.model.BasePathAbstractES;
import es.redmic.models.es.tools.distribution.model.Register;

public class TaxonDistribution extends BasePathAbstractES{
	
	private String scientificName;
	private String authorship;
	private String equivalent;
	
	private List<Register> registers;
	
	public List<Register> getRegisters() {
		return registers;
	}
	public void setRegisters(List<Register> registers) {
		this.registers = registers;
	}
	
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getAuthorship() {
		return authorship;
	}
	public void setAuthorship(String authorship) {
		this.authorship = authorship;
	}
	public String getEquivalent() {
		return equivalent;
	}
	public void setEquivalent(String equivalent) {
		this.equivalent = equivalent;
	}
	
}
