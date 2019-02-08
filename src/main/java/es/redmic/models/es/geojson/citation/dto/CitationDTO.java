package es.redmic.models.es.geojson.citation.dto;

import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;

public class CitationDTO extends MetaFeatureDTO<CitationPropertiesDTO, Point> {

	public CitationDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		this.get_meta().setCategory(DataPrefixType.CITATION);
	}
}