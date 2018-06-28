package es.redmic.models.es.geojson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoJsonObject {

	@JsonProperty("type")
	protected GeoJSONFeatureType geoJSONObjectType;

	private double[] bbox;

	public double[] getBbox() {
		return bbox;
	}

	public void setBbox(double[] bbox) {
		this.bbox = bbox;
	}

	public void setGeoJSONObjectType(GeoJSONFeatureType geoJSONObjectType) {
		this.geoJSONObjectType = geoJSONObjectType;
	}
}
