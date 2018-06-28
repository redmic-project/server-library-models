package es.redmic.test.unit.geodata.tracking.animal.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.tracking.animal.dto.AnimalTrackingPropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AnimalTrackingPropertiesDTOTest extends DTOBaseTest<AnimalTrackingPropertiesDTO> {

	private static AnimalTrackingPropertiesDTO dto = new AnimalTrackingPropertiesDTO();

	@Before
	public void reset() {

		dto = new AnimalTrackingPropertiesDTO();
		dto.setActivityId("r.1.2.3");
		dto.setAnimal(CompleteDTOUtils.completeAnimalDTO());
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
	public void validationDTO_ReturnNotNullError_IfAnimalIsNull() {

		dto.setAnimal(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDeviceIsNull() {

		dto.setDevice(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}