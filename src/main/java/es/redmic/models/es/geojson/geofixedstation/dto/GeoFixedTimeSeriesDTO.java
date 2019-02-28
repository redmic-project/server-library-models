package es.redmic.models.es.geojson.geofixedstation.dto;

import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.FixedSurveySeriesPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class GeoFixedTimeSeriesDTO extends MetaFeatureDTO<FixedSurveySeriesPropertiesDTO, Point> {

	public GeoFixedTimeSeriesDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.FIXED_TIMESERIES);
	}
}