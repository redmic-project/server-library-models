package es.redmic.test.unit.geodata.common.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.common.model.Feature;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class FeatureTest extends DTOBaseTest<Feature<?, ?>> {

	@SuppressWarnings("rawtypes")
	private Feature dto;

	@SuppressWarnings("rawtypes")
	@Before
	public void reset() {

		dto = new Feature();
		dto.setUuid("sdewewewe13-sdsd");
		dto.set_parentId("dddd");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUuidIsNull() {

		dto.setUuid(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}