package es.redmic.models.es.geojson.common.model;

import com.vividsolutions.jts.geom.Point;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;

public class GeoPointData extends Feature<GeoDataProperties, Point> {

	public GeoPointData() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
