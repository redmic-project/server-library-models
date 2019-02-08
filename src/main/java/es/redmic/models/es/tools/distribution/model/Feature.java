package es.redmic.models.es.tools.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.geojson.GeoJsonObject;


public class Feature<TProperties extends Properties, TGeometry extends Geometry> extends GeoJsonObject implements BaseES<Long> {

	private Long id;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private TProperties properties;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private TGeometry geometry;

	public void setProperties(TProperties properties) {
		this.properties = properties;
	}

	public TProperties getProperties() {
		return properties;
	}

	public TGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(TGeometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
