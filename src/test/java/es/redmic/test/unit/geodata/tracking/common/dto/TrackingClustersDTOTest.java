package es.redmic.test.unit.geodata.tracking.common.dto;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import es.redmic.exception.elasticsearch.ESParseException;
import es.redmic.models.es.geojson.common.model.GeoHitWrapper;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.properties.model.GeoDataProperties;
import es.redmic.models.es.geojson.properties.model.InTrack;
import es.redmic.models.es.geojson.tracking.common.TrackingClustersDTO;

public class TrackingClustersDTOTest {
	
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
	static GeometryFactory geomFactory = new GeometryFactory();
	
	TrackingClustersDTO clusterDTO;
	int ZOOM_LEVEL = 7;
	
	static GeoHitWrapper<GeoDataProperties, Point> h1;
	static GeoHitWrapper<GeoDataProperties, Point> h2;
	static GeoHitWrapper<GeoDataProperties, Point> h3;
	static Double x1, y1, x2, y2, x3, y3, cx2, cy2, cx3, cy3;

	@BeforeClass
	public static void setUp() {
		
		h1 = new GeoHitWrapper<GeoDataProperties, Point>();
		h2 = new GeoHitWrapper<GeoDataProperties, Point>();
		h3 = new GeoHitWrapper<GeoDataProperties, Point>();

		GeoPointData f1 = new GeoPointData();
		GeoPointData f2 = new GeoPointData();
		GeoPointData f3 = new GeoPointData();

		h1.set_source(f1);
		h2.set_source(f2);
		h3.set_source(f3);
		
		x1 = -14.86667d;
		y1 = 27.44999d;
		x2 = -14.26666d;
		y2 = 28.86669d;
		x3 = -13.48335d;
		y3 = 28.25000d;

		cx2 = -14.566665d; 
		cy2 = 28.15834d; 
		cx3 = -14.20556d; 
		cy3 = 28.18889333333333d;
		
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

		f2.setGeometry(point2);
		f2.setProperties(p2);

		f3.setGeometry(point3);
		f3.setProperties(p3);
	}

	@Before
	public void beforeEach() throws NoSuchAuthorityCodeException, FactoryException {

		clusterDTO = Mockito.spy(new TrackingClustersDTO(ZOOM_LEVEL));

	}

	@Test
	public void should_ReturnFalse_When_Pass2RemotePoints() {

		Point point1 = geomFactory.createPoint(new Coordinate(x1, y1));
		Point point2 = geomFactory.createPoint(new Coordinate(x2, y2));
		
		assertFalse(clusterDTO.checkPointBelongsToCluster(point1, point2, ZOOM_LEVEL));
	}
	
	@Test
	public void should_ReturnTrue_When_Pass2NearbyPoints() {
		double displacament = 0.01; 
			
		Point point1 = geomFactory.createPoint(new Coordinate(x1, y1));
		Point point2 = geomFactory.createPoint(new Coordinate(x1 + displacament, y1 - displacament));
		
		assertTrue(clusterDTO.checkPointBelongsToCluster(point1, point2, ZOOM_LEVEL));
	}
	
	@Test
	public void should_Return3Clusters_When_Pass3RemotePoints() {
		
		clusterDTO.addFeature(h1);
		clusterDTO.addFeature(h2);
		clusterDTO.addFeature(h3);
		
		verify(clusterDTO, times(2)).checkPointBelongsToCluster(any(), any(), eq(ZOOM_LEVEL));
		
		assertEquals(clusterDTO.size(), 3);
		
		Coordinate firstClusterCoordinates = clusterDTO.get(0).getGeometry().getCoordinate();
		Coordinate secondClusterCoordinates = clusterDTO.get(1).getGeometry().getCoordinate();
		Coordinate thirdClusterCoordinates = clusterDTO.get(2).getGeometry().getCoordinate();
		
		assertEquals(firstClusterCoordinates, h1.get_source().getGeometry().getCoordinate());
		assertEquals(secondClusterCoordinates, h2.get_source().getGeometry().getCoordinate());
		assertEquals(thirdClusterCoordinates, h3.get_source().getGeometry().getCoordinate());
	}
	
	@Test
	public void should_Return2Clusters_When_Pass2SamePointsAnd1RemotePoint() {
		
		clusterDTO.addFeature(h1);
		clusterDTO.addFeature(h1);
		clusterDTO.addFeature(h3);
		
		verify(clusterDTO, times(2)).checkPointBelongsToCluster(any(), any(), eq(ZOOM_LEVEL));
		
		assertEquals(clusterDTO.size(), 2);
		
		Coordinate firstClusterCoordinates = clusterDTO.get(0).getGeometry().getCoordinate();
		Coordinate secondClusterCoordinates = clusterDTO.get(1).getGeometry().getCoordinate();
		
		assertEquals(firstClusterCoordinates, h1.get_source().getGeometry().getCoordinate());
		assertEquals(secondClusterCoordinates, h3.get_source().getGeometry().getCoordinate());
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