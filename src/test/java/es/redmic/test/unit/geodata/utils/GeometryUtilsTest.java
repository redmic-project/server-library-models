package es.redmic.test.unit.geodata.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.redmic.models.es.geojson.common.utils.GeometryUtils;

public class GeometryUtilsTest {
	
	@Test
	public void should_resolutionExpected_when_zoomEqualZeroAndLatEqualZero() {
		double resolutionExpected = 78271.5170;
		double a = GeometryUtils.getMeterByPixel(1, 0);
		assertEquals(resolutionExpected, a, 00.1);
	}
}
