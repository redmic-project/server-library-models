package es.redmic.models.es.geojson.common.model;

import org.locationtech.jts.geom.LineString;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;

public class GeoLineStringData extends Feature<GeoDataProperties, LineString> {

	public GeoLineStringData() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
