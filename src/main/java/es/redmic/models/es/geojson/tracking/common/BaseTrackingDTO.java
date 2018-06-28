package es.redmic.models.es.geojson.tracking.common;

import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class BaseTrackingDTO<TDTO extends BaseTrackingPropertiesDTO, TGeometry extends Geometry>
		extends MetaFeatureDTO<TDTO, TGeometry>{

	public BaseTrackingDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
	}
}
