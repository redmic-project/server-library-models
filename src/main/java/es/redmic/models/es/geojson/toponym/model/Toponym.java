package es.redmic.models.es.geojson.toponym.model;


import org.locationtech.jts.geom.Point;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.model.Feature;

public class Toponym extends Feature<ToponymProperties, Point> {

	public Toponym() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
