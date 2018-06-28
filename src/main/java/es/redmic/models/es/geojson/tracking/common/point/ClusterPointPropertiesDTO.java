package es.redmic.models.es.geojson.tracking.common.point;

import es.redmic.models.es.administrative.model.PlatformCompact;
import es.redmic.models.es.administrative.taxonomy.model.AnimalWithOutTaxon;
import es.redmic.models.es.geojson.common.dto.PropertiesDTO;


public class ClusterPointPropertiesDTO extends PropertiesDTO {
	
	Object element;

	public Object getElement() {
		return element;
	}

	public void setElement(AnimalWithOutTaxon animal) {
		this.element = animal;
	}
	
	public void setElement(PlatformCompact platform) {
		this.element = platform;
	}
}
