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

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Point;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.tracking.utils.TrackingUtils;

public class TrackingClusterDTO extends MetaFeatureDTO<ClusterPropertiesDTO, Point> implements BaseTrackingClusterDTO{

	public TrackingClusterDTO() {

		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		setProperties(new ClusterPropertiesDTO());
	}
	
	public TrackingClusterDTO(GeoPointData feature) {
		this();
		addPoinInCluster(feature);
	}

	public void addPoinInCluster(GeoPointData feature) {

		getProperties().addDate(feature.getProperties().getInTrack().getDate());
		getProperties().addUuid(feature.getUuid());

		TrackingUtils.fillElement(feature, this);
		
		if (getGeometry() == null)
			setGeometry(feature.getGeometry());
	}

	@JsonIgnore
	public Point getCentroid() {
		return getGeometry();
	}
	
}
