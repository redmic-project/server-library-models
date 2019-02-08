package es.redmic.models.es.geojson.tracking.common;

import org.locationtech.jts.geom.Point;

import es.redmic.models.es.administrative.dto.PlatformCompactDTO;
import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.common.dto.MetaDataFeatureDTO;

public class ElementTrackingDTO extends BaseTrackingDTO<ElementTrackingPropertiesDTO, Point>{

	public ElementTrackingDTO() {
		super();
		setProperties(new ElementTrackingPropertiesDTO());
	}
	
	@Override
	public MetaDataFeatureDTO get_meta() {
		
		if (this.getProperties().getElement() instanceof PlatformCompactDTO)
			super.get_meta().setCategory(DataPrefixType.PLATFORM_TRACKING);
		else
			super.get_meta().setCategory(DataPrefixType.ANIMAL_TRACKING);
		return super.get_meta();
	}
}
