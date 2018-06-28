package es.redmic.test.unit.geodata.infrastructure.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.infrastructure.dto.InfrastructurePropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class InfrastructurePropertiesDTOTest extends DTOBaseTest<InfrastructurePropertiesDTO> {

	private static InfrastructurePropertiesDTO dto = new InfrastructurePropertiesDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeInfrastructurePropertiesDTO();
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
	public void validationDTO_ReturnNotNullError_IfInfrastructureTypeIsNull() {

		dto.setInfrastructureType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfCodeIsNull() {

		dto.setCode(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCodeExceedsSize() {

		dto.setCode(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCodeIsLessThanMinSize() {

		dto.setCode("");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(250));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfUrlExceedsSize() {

		dto.setUrl("http://" + generateString(500) + ".com");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnURLError_IfUrlIsBadFormat() {

		dto.setUrl("noValidUrl");

		checkDTOHasError(dto, URL_MESSAGE_TEMPLATE);
	}
}