package es.redmic.models.es.geojson.tracking.utils;

import com.vividsolutions.jts.geom.Geometry;

import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.Feature;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.geojson.tracking.common.point.ClusterPointPropertiesDTO;

public class TrackingUtils {

	public static MetaFeatureDTO<? extends ClusterPointPropertiesDTO, ? extends Geometry> fillElement(
			Feature<GeoDataProperties, ? extends Geometry> feature,
			MetaFeatureDTO<? extends ClusterPointPropertiesDTO, ? extends Geometry> dto) {

		if (feature.getProperties().getInTrack().getPlatform() != null)
			dto.getProperties().setElement(feature.getProperties().getInTrack().getPlatform());
		else if ((feature.getProperties().getCollect() != null)
				&& (feature.getProperties().getCollect().getAnimal() != null))
			dto.getProperties().setElement(feature.getProperties().getCollect().getAnimal());

		return dto;
	}
}
