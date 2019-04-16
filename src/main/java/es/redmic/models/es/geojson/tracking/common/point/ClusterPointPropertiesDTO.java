package es.redmic.models.es.geojson.tracking.common.point;

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

import es.redmic.models.es.administrative.model.PlatformCompact;
import es.redmic.models.es.administrative.taxonomy.model.AnimalWithOutTaxon;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;


public class ClusterPointPropertiesDTO extends PropertiesDTO {
	
	Object element;

	public Object getElement() {
		return element;
	}

	public void setElement(AnimalWithOutTaxon animal) {
		this.element = animal;
	}
	
	public void setElement(PlatformCompact platform) {
		this.element = platform;
	}
}
