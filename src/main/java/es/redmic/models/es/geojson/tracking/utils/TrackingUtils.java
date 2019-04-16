package es.redmic.models.es.geojson.tracking.utils;

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

import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.Feature;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.geojson.tracking.common.point.ClusterPointPropertiesDTO;

public class TrackingUtils {

	public static MetaFeatureDTO<? extends ClusterPointPropertiesDTO, ? extends Geometry> fillElement(
			Feature<GeoDataProperties, ? extends Geometry> feature,
			MetaFeatureDTO<? extends ClusterPointPropertiesDTO, ? extends Geometry> dto) {

		if (feature.getProperties().getInTrack().getPlatform() != null)
			dto.getProperties().setElement(feature.getProperties().getInTrack().getPlatform());
		else if ((feature.getProperties().getCollect() != null)
				&& (feature.getProperties().getCollect().getAnimal() != null))
			dto.getProperties().setElement(feature.getProperties().getCollect().getAnimal());

		return dto;
	}
}
