package es.redmic.test.unit.geodata.tracking.platform.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.tracking.platform.dto.PlatformTrackingPropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class PlatformTrackingPropertiesDTOTest extends DTOBaseTest<PlatformTrackingPropertiesDTO> {

	private static PlatformTrackingPropertiesDTO dto = new PlatformTrackingPropertiesDTO();

	@Before
	public void reset() {

		dto.setActivityId("r.1.2.3");
		dto.setPlatform(CompleteDTOUtils.completePlatformDTO());
		dto.setDevice(CompleteDTOUtils.completeDeviceDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	// @Test
	public void validationDTO_ReturnNotNullError_IfActivityIsNull() {

		dto.setActivityId(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfPlatformIsNull() {

		dto.setPlatform(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDeviceIsNull() {

		dto.setDevice(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}