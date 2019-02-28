package es.redmic.models.es.geojson.tracking.platform.dto;

import java.util.ArrayList;
import java.util.List;

import org.locationtech.jts.algorithm.Centroid;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import es.redmic.models.es.common.DataPrefixType;
import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaDataFeatureDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoPointData;

public class PlatformTrackingClusterDTO extends MetaFeatureDTO<ClusterPropertiesDTO, Point> {

	private GeometryFactory geomFactory = new GeometryFactory();

	private List<Geometry> geometries = new ArrayList<Geometry>();

	public PlatformTrackingClusterDTO() {

		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		setProperties(new ClusterPropertiesDTO());
	}

	public void addPoint(GeoHitWrapper<?, Point> point) {

		GeoPointData feature = (GeoPointData) point.get_source();
		getProperties().addDate(feature.getProperties().getInTrack().getDate());
		getProperties().addUuid(feature.getUuid());

		MetaDataFeatureDTO meta = new MetaDataFeatureDTO();
		meta.setCategory(DataPrefixType.PLATFORM_TRACKING);
		meta.setVersion(point.get_version());
		set_meta(meta);
		updateCentroidPoint(feature.getGeometry());
	}

	private void updateCentroidPoint(Geometry point) {

		geometries.add(point);
		Centroid centroid = new Centroid(geomFactory.buildGeometry(geometries));
		setGeometry(geomFactory.createPoint(centroid.getCentroid()));
	}
}
