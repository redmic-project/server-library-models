package es.redmic.models.es.tools.distribution.model;

import org.locationtech.jts.geom.Polygon;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.tools.distribution.species.model.TaxonProperties;

public class Distribution extends Feature<TaxonProperties, Polygon>{

	public Distribution() {
		super();
		this.setGeoJSONObjectType(GeoJSONFeatureType.FEATURE);
	}
}