package es.redmic.models.es.geojson.tracking.common;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ElementTrackingPropertiesDTO extends BaseTrackingPropertiesDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	private Object element;

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}
}
