package es.redmic.models.es.geojson.isolines.dto;

import org.locationtech.jts.geom.MultiLineString;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class IsolinesDTO extends MetaFeatureDTO<IsolinesPropertiesDTO, MultiLineString> {

	public IsolinesDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.ISOLINES);
	}
}
