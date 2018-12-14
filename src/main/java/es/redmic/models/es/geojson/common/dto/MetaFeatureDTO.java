package es.redmic.models.es.geojson.common.dto;

import org.locationtech.jts.geom.Geometry;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public abstract class MetaFeatureDTO<TProperties extends PropertiesDTO, TGeometry extends Geometry>
		extends FeatureDTO<TProperties, TGeometry> {

	public MetaFeatureDTO() {
		super();
		this._meta = new MetaDataFeatureDTO();
	}

	private String uuid;

	@JsonSchemaIgnore
	private MetaDataFeatureDTO _meta;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public MetaDataFeatureDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataFeatureDTO _meta) {
		this._meta = _meta;
	}

	@Override
	public void setProperties(TProperties properties) {
		super.setProperties(properties);
	}

	@Override
	public TProperties getProperties() {
		return super.getProperties();
	}
}
