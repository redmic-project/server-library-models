package es.redmic.models.es.geojson.tracking.animal.dto;

import com.vividsolutions.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.tracking.common.BaseTrackingDTO;

public class AnimalTrackingDTO extends BaseTrackingDTO<AnimalTrackingPropertiesDTO, Point>{

	public AnimalTrackingDTO() {
		super();
		this.get_meta().setCategory(DataPrefixType.ANIMAL_TRACKING);
	}
}
