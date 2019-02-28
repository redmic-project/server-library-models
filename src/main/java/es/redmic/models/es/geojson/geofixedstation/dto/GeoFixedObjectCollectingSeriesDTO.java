package es.redmic.models.es.geojson.geofixedstation.dto;

import org.locationtech.jts.geom.LineString;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.FixedSurveySeriesPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class GeoFixedObjectCollectingSeriesDTO extends MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, LineString> {
	
	public GeoFixedObjectCollectingSeriesDTO() {
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.OBJECT_COLLECTING);
	}
}
