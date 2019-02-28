package es.redmic.models.es.geojson.tracking.common.linestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.locationtech.jts.algorithm.Centroid;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.geojson.GeoJSONFeatureType;
import es.redmic.models.es.geojson.common.dto.ClusterPropertiesDTO;
import es.redmic.models.es.geojson.common.dto.MetaFeatureDTO;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.tracking.common.BaseTrackingClusterDTO;
import es.redmic.models.es.geojson.tracking.common.TrackingClusterDTO;
import es.redmic.models.es.geojson.tracking.utils.TrackingUtils;

public class TrackingLinestringClusterDTO extends MetaFeatureDTO<ClusterLineStringPropertiesDTO, LineString>
		implements BaseTrackingClusterDTO {

	private List<Geometry> geometries = new ArrayList<Geometry>();

	private GeometryFactory geomFactory = new GeometryFactory();

	public TrackingLinestringClusterDTO() {
		super();
		this.setType(GeoJSONFeatureType.FEATURE);
		setProperties(new ClusterLineStringPropertiesDTO());
	}

	public TrackingLinestringClusterDTO(TrackingClusterDTO firstAxis, GeoPointData secondAxis) {
		this();

		TrackingUtils.fillElement(secondAxis, this);

		getProperties().getAxesProps().add(firstAxis.getProperties());
		getProperties().getAxesProps().add(new ClusterPropertiesDTO(secondAxis));

		createGeometry(firstAxis.getGeometry(), secondAxis.getGeometry());
		newCentroid(secondAxis.getGeometry());
	}

	public TrackingLinestringClusterDTO(GeoPointData firstAxis, GeoPointData secondAxis) {
		this();

		TrackingUtils.fillElement(firstAxis, this);

		getProperties().getAxesProps().add(new ClusterPropertiesDTO(firstAxis));
		getProperties().getAxesProps().add(new ClusterPropertiesDTO(secondAxis));

		createGeometry(firstAxis.getGeometry(), secondAxis.getGeometry());
		newCentroid(secondAxis.getGeometry());
	}

	private void createGeometry(Point firstAxis, Point secondAxis) {
		Coordinate[] coordinates = new Coordinate[] { firstAxis.getCoordinate(), secondAxis.getCoordinate() };

		setGeometry(geomFactory.createLineString(coordinates));
	}

	public void addAxis(GeoPointData feature) {
		List<ClusterPropertiesDTO> axisProps = getProperties().getAxesProps();
		axisProps.add(new ClusterPropertiesDTO(feature));

		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		coordinates.addAll(Arrays.asList(getGeometry().getCoordinates()));

		coordinates.add(feature.getGeometry().getCoordinate());
		newCentroid(feature.getGeometry());

		Coordinate[] coord = new Coordinate[coordinates.size()];
		setGeometry(geomFactory.createLineString(coordinates.toArray(coord)));
	}

	@Override
	public void addPoinInCluster(GeoPointData feature) {

		List<ClusterPropertiesDTO> axisProps = getProperties().getAxesProps();

		if (axisProps.size() > 1) {
			ClusterPropertiesDTO lastAxis = axisProps.get(axisProps.size() - 1);
			lastAxis.addFeaturePropsInCluster(feature);

			List<Coordinate> coordinates = Arrays.asList(getGeometry().getCoordinates());
			coordinates.set(coordinates.size() - 1, updateCentroid(feature.getGeometry()));

			Coordinate[] coord = new Coordinate[coordinates.size()];
			setGeometry(geomFactory.createLineString(coordinates.toArray(coord)));
		} else {
			// TODO Lanzar exception, porque una línea debe de crearse con 2 puntos
		}
	}

	protected void newCentroid(Geometry point) {

		geometries.add(point);
	}

	protected Coordinate updateCentroid(Geometry point) {

		geometries.add(point);

		Centroid centroid = new Centroid(geomFactory.buildGeometry(geometries));

		return centroid.getCentroid();
	}

	@Override
	@JsonIgnore
	public Point getCentroid() {

		Centroid centroid = new Centroid(geomFactory.buildGeometry(geometries));

		return geomFactory.createPoint(centroid.getCentroid());
	}
}
