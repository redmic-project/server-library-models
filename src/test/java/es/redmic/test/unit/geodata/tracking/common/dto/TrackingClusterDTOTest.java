package es.redmic.test.unit.geodata.tracking.common.dto;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.vividsolutions.jts.algorithm.CentroidPoint;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import es.redmic.exception.elasticsearch.ESParseException;
import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.geojson.properties.model.InTrack;
import es.redmic.models.es.geojson.tracking.common.TrackingClusterDTO;

public class TrackingClusterDTOTest {
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
	static GeometryFactory geomFactory = new GeometryFactory();
	static TrackingClusterDTO clusterDTO;
	
	static GeoPointData f1;
	static GeoPointData f2;
	static GeoPointData f3;
	static Double x1, y1, x2, y2, x3, y3;

	@BeforeClass
	public static void setUp() {
		
		GeoHitWrapper<GeoDataProperties, Point> h1 = new GeoHitWrapper<GeoDataProperties, Point>();
		GeoHitWrapper<GeoDataProperties, Point> h2 = new GeoHitWrapper<GeoDataProperties, Point>();
		GeoHitWrapper<GeoDataProperties, Point> h3 = new GeoHitWrapper<GeoDataProperties, Point>();

		f1 = new GeoPointData();
		f2 = new GeoPointData();
		f3 = new GeoPointData();

		h1.set_source(f1);
		h2.set_source(f2);
		h3.set_source(f3);
		
		x1 = -14.86667d;
		y1 = 27.44999d;
		x2 = -14.26666d;
		y2 = 28.86669d;
		x3 = -13.48335d;
		y3 = 28.25000d;

		GeoDataProperties p1 = new GeoDataProperties();
		InTrack i1 = new InTrack();
		i1.setId("it-234");
		i1.setDate(getDateTime("2009-08-29T12:32:00.000+01:00"));
		p1.setInTrack(i1);
		
		GeoDataProperties p2 = new GeoDataProperties();
		InTrack i2 = new InTrack();
		i2.setId("it-256");
		i2.setDate(getDateTime("2009-08-29T13:32:00.000+01:00"));
		p2.setInTrack(i2);
		
		GeoDataProperties p3 = new GeoDataProperties();
		InTrack i3 = new InTrack();
		i3.setId("it-289");
		i3.setDate(getDateTime("2009-08-29T14:32:00.000+01:00"));
		p3.setInTrack(i3);
		
		Point point1 = geomFactory.createPoint(new Coordinate(x1, y1));
		Point point2 = geomFactory.createPoint(new Coordinate(x2, y2));
		Point point3 = geomFactory.createPoint(new Coordinate(x3, y3));
		
		f1.setGeometry(point1);
		f1.setProperties(p1);
		f1.setUuid("uuuid1");

		f2.setGeometry(point2);
		f2.setProperties(p2);
		f2.setUuid("uuuid2");

		f3.setGeometry(point3);
		f3.setProperties(p3);
		f3.setUuid("uuuid3");
	}

	@Before
	public void beforeEach() {

		clusterDTO = new TrackingClusterDTO();
	}

	@Test
	public void should_ReturnClusterCoordinatesEqualsAddedPoint_When_AddPoint_APointInEmptyCluster() {

		clusterDTO.addPoinInCluster(f1);

		assertTrue(clusterDTO.getGeometry().getCoordinate().equals2D(f1.getGeometry().getCoordinate()));
	}

	@Test
	public void should_ReturnFirstGeometry_When_AddPoint_ThreePoinstInCluster() {
		
		CentroidPoint centroid = new CentroidPoint();
		ArrayList<GeoPointData> points = new ArrayList<GeoPointData>();
		points.add(f1);
		points.add(f2);
		points.add(f3);

		points.forEach(p -> {
			clusterDTO.addPoinInCluster(p);
			centroid.add(p.getGeometry());
		}); 

		assertTrue(clusterDTO.getGeometry().getCoordinate().equals2D(f1.getGeometry().getCoordinate()));
	}
	
	private static DateTime getDateTime(String dateString) {
		
		if (dateString == null)
			return null;
		
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			throw new ESParseException(e);
		}
		return new DateTime(date);
	}
}