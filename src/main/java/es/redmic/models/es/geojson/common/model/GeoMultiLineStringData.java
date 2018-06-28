package es.redmic.models.es.geojson.common.model;

import com.vividsolutions.jts.geom.MultiLineString;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;

public class GeoMultiLineStringData extends Feature<GeoDataProperties, MultiLineString> {

	public GeoMultiLineStringData() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
