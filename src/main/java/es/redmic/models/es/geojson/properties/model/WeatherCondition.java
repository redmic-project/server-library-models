package es.redmic.models.es.geojson.properties.model;

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

import es.redmic.models.es.common.model.Compact;
import es.redmic.models.es.common.model.DomainES;

public class WeatherCondition extends Compact {

	private String acronym;
	
	private DomainES seaConditionType;
	
	public String getAcronym() {
		return acronym;
	}
	
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	public DomainES getSeaConditionType() {
		return seaConditionType;
	}
	
	public void setSeaConditionType(DomainES seaConditionType) {
		this.seaConditionType = seaConditionType;
	} 
}
