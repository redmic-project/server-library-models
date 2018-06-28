package es.redmic.models.es.geojson.tracking.common;

import com.vividsolutions.jts.geom.Point;

import es.redmic.models.es.geojson.common.model.GeoPointData;

public interface BaseTrackingClusterDTO {
	
	public Point getCentroid();
	public void addPoinInCluster(GeoPointData feature);

}
