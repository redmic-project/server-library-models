package es.redmic.models.es.geojson.tracking.platform.dto;

import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.tracking.common.BaseTrackingDTO;

public class PlatformTrackingDTO extends BaseTrackingDTO<PlatformTrackingPropertiesDTO, Point>{

	public PlatformTrackingDTO() {
		super();
		this.get_meta().setCategory(DataPrefixType.PLATFORM_TRACKING);
	}
}
