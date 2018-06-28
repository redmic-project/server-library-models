package es.redmic.models.es.geojson.common.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.geojson.GeoJSONFeatureType;

public class Feature<TProperties extends Properties, TGeometry extends Geometry> extends BaseAbstractES {

	@NotNull
	@Size(min = 1, max = 50)
	private String uuid;
	
	@JsonIgnore
	private String _parentId;

	protected GeoJSONFeatureType type;

	private TProperties properties;

	private TGeometry geometry;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	@JsonIgnore
	public String get_parentId() {
		return _parentId;
	}

	@JsonIgnore
	public void set_parentId(String _parent) {
		this._parentId = _parent;
	}

	public void setType(GeoJSONFeatureType type) {
		this.type = type;
	}

	public GeoJSONFeatureType getType() {
		return type;
	}

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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		@SuppressWarnings("rawtypes")
		Feature feature = (Feature) o;
		if (properties != null ? !properties.equals(feature.properties) : feature.properties != null)
			return false;
		if (geometry != null ? !geometry.equals(feature.geometry) : feature.geometry != null)
			return false;
		return !(getId() != null ? !(getId() == feature.getId()) : feature.getId() != null);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (properties != null ? properties.hashCode() : 0);
		result = 31 * result + (geometry != null ? geometry.hashCode() : 0);
		result = 31 * result + (getId() != null ? getId().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Feature{properties=" + properties + ", geometry=" + geometry + ", id='" + getId() + "'}";
	}
}