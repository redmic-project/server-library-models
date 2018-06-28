package es.redmic.models.es.geojson.area.dto;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.vividsolutions.jts.geom.MultiPolygon;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class AreaDTO extends MetaFeatureDTO<AreaPropertiesDTO, MultiPolygon> {

	public AreaDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.AREA);
	}

	@JsonSchemaIgnore
	private MultiPolygon geometry;
}
