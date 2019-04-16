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

import org.locationtech.jts.geom.Point;

import es.redmic.models.es.administrative.dto.PlatformCompactDTO;
import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.common.dto.MetaDataFeatureDTO;

public class ElementTrackingDTO extends BaseTrackingDTO<ElementTrackingPropertiesDTO, Point>{

	public ElementTrackingDTO() {
		super();
		setProperties(new ElementTrackingPropertiesDTO());
	}
	
	@Override
	public MetaDataFeatureDTO get_meta() {
		
		if (this.getProperties().getElement() instanceof PlatformCompactDTO)
			super.get_meta().setCategory(DataPrefixType.PLATFORM_TRACKING);
		else
			super.get_meta().setCategory(DataPrefixType.ANIMAL_TRACKING);
		return super.get_meta();
	}
}
