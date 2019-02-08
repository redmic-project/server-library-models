package es.redmic.models.es.geojson.common.utils;

import org.geotools.factory.Hints;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.ReferencingFactoryFinder;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CRSAuthorityFactory;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import org.locationtech.jts.geom.Coordinate;

import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;

public abstract class GeometryUtils {

	// Earth ellipsoid major axis defined by WGS 84 in meters
	private static final double EARTH_SEMI_MAJOR_AXIS = 6378137.0;

	// Earth ellipsoid equator length in meters
	private static final double EARTH_PERIMETER = 2 * Math.PI * EARTH_SEMI_MAJOR_AXIS;

	private static final int TILE_SIZE = 256;

	public static CoordinateReferenceSystem getCRS(String crsName) {
		Hints hints = new Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, Boolean.TRUE);
		CRSAuthorityFactory factory = ReferencingFactoryFinder.getCRSAuthorityFactory("EPSG", hints);

		try {
			return factory.createCoordinateReferenceSystem(crsName);
		} catch (FactoryException e) {
			e.printStackTrace();
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION, e);
		}
	}

	public static Double getDistanceInMeters(Coordinate previousCoordinate, Coordinate currentCoordinate,
			CoordinateReferenceSystem crs) {

		Double distanceInMeters;
		try {
			distanceInMeters = JTS.orthodromicDistance(previousCoordinate, currentCoordinate, crs);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION, e);
		}

		return distanceInMeters;
	}

	public static double getMeterByPixel(int zoom, double lat) {
		double latRad = Math.toRadians(lat);
		double a = EARTH_PERIMETER * Math.cos(latRad);
		double b = Math.pow(2, zoom) * TILE_SIZE;
		double c = a / b;

		return c;
	}
}
