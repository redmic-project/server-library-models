package es.redmic.models.es.geojson.toponym.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaDataFeatureDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

@JsonIgnoreProperties(value = { "uuid" })
public class ToponymDTO extends MetaFeatureDTO<ToponymPropertiesDTO, Point> {

	public ToponymDTO() {
		super();
		this._meta = new MetaDataFeatureDTO();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.TOPONYM);
	}

	@JsonSchemaIgnore
	private MetaDataFeatureDTO _meta;

	public MetaDataFeatureDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataFeatureDTO _meta) {
		this._meta = _meta;
	}

	public void setProperties(ToponymPropertiesDTO properties) {
		super.setProperties(properties);
	}

	public ToponymPropertiesDTO getProperties() {
		return super.getProperties();
	}
}
