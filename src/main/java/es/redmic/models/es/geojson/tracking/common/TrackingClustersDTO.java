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

import java.util.ArrayList;

import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Point;

import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.common.utils.GeometryUtils;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;

public class TrackingClustersDTO extends ArrayList<TrackingClusterDTO>{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8846475486009704036L;
	
	private static String CRS_NAME = "EPSG:4326";
	private static int MIN_PIXELS_TO_CLUSTER = 7;
	
	private int zoomLevel;
	private CoordinateReferenceSystem crs;
	
	private Long itemsInvolved;
	
	public TrackingClustersDTO(int zoomLevel) {
		super();
		this.zoomLevel = zoomLevel;
		this.crs = GeometryUtils.getCRS(CRS_NAME);
		
		itemsInvolved = 0L;
	}
		
	public boolean addFeature(GeoHitWrapper<GeoDataProperties, Point> item) {

		TrackingClusterDTO lastCluster = lastCluster();
		GeoPointData feature = (GeoPointData) item.get_source();
		
		itemsInvolved++;
		
		if (!isEmpty() && checkPointBelongsToCluster(lastCluster.getCentroid(), item.get_source().getGeometry(), zoomLevel))
			lastCluster.addPoinInCluster(feature);
		else {
			TrackingClusterDTO cluster = new TrackingClusterDTO(feature);
			add(cluster);
		}

        return true;
    }
	
	public TrackingClusterDTO lastCluster() {
		TrackingClusterDTO item = null;
		if (!isEmpty())
			item = get(size() - 1);

		return item;
	}

	public boolean checkPointBelongsToCluster(Point cluster, Point point, int zoomLevel) {

		Double distanceInMeters = GeometryUtils.getDistanceInMeters(cluster.getCoordinate(), point.getCoordinate(), crs),
				distanceInPixels = distanceInMeters / GeometryUtils.getMeterByPixel(zoomLevel, point.getCoordinate().y);
		
		return distanceInPixels <= MIN_PIXELS_TO_CLUSTER;
	}
	
	@JsonIgnore
	public Long getItemsInvolved() {
		return itemsInvolved;
	}

	@JsonIgnore
	public void setItemsInvolved(Long itemsInvolved) {
		this.itemsInvolved = itemsInvolved;
	}
}
