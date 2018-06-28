package es.redmic.test.unit.atlas.dto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.atlas.LatLonBoundingBox;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class LatLonBoundingBoxTest extends DTOBaseTest<LatLonBoundingBox> {

	private static LatLonBoundingBox dto = new LatLonBoundingBox();

	@Before
	public void reset() {

		dto.setMaxX(2.0);
		dto.setMaxY(2.0);
		dto.setMinX(2.0);
		dto.setMinY(2.0);
	}

	@Test
	public void validation_NoReturnError_IfObjectIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validation_ReturnNotNullError_IfFieldIsNull() {

		dto.setMaxX(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void equal_ReturnFalse_IfObjectNotIsInstanceOfLatLonBoundingBox() {

		assertFalse(dto.equals(new Object()));
	}

	@Test
	public void equal_ReturnFalse_IfObjectIsDiferent() {

		LatLonBoundingBox obj = new LatLonBoundingBox();

		obj.setMaxX(3.0);
		obj.setMaxY(2.0);
		obj.setMinX(2.0);
		obj.setMinY(2.0);

		assertFalse(dto.equals(obj));
	}

	@Test
	public void equal_ReturnTrue_IfObjectIsEqual() {

		assertTrue(dto.equals(dto));
	}
}