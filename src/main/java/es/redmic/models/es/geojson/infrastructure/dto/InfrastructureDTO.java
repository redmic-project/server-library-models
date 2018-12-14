package es.redmic.models.es.geojson.infrastructure.dto;


import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class InfrastructureDTO extends MetaFeatureDTO<InfrastructurePropertiesDTO, Point> {

	public InfrastructureDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.INFRASTRUCTURE);
	}
}
