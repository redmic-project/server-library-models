package es.redmic.models.es.geojson.tracking.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vividsolutions.jts.geom.Point;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.tracking.utils.TrackingUtils;

public class TrackingClusterDTO extends MetaFeatureDTO<ClusterPropertiesDTO, Point> implements BaseTrackingClusterDTO{

	public TrackingClusterDTO() {

		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		setProperties(new ClusterPropertiesDTO());
	}
	
	public TrackingClusterDTO(GeoPointData feature) {
		this();
		addPoinInCluster(feature);
	}

	public void addPoinInCluster(GeoPointData feature) {

		getProperties().addDate(feature.getProperties().getInTrack().getDate());
		getProperties().addUuid(feature.getUuid());

		TrackingUtils.fillElement(feature, this);
		
		if (getGeometry() == null)
			setGeometry(feature.getGeometry());
	}

	@JsonIgnore
	public Point getCentroid() {
		return getGeometry();
	}
	
}