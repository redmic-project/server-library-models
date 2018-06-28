package es.redmic.models.es.geojson.common.model;

import com.vividsolutions.jts.geom.MultiPolygon;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;

public class GeoMultiPolygonData extends Feature<GeoDataProperties, MultiPolygon> {

	public GeoMultiPolygonData() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
