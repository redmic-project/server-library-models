package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.PlatformDTO;
import es.redmic.models.es.maintenance.administrative.dto.PlatformTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class PlatformDTOTest extends DTOBaseTest<PlatformDTO> {

	private static PlatformDTO dto = new PlatformDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completePlatformDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfNameIsNull() {

		dto.setName(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameHasInsufficientLength() {

		dto.setName("");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setLicence(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setLicence(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfLicenceExceedsSize() {

		dto.setLicence(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfContactPhoneExceedsSize() {

		dto.setContactPhone("45345554433423445553");

		checkDTOHasError(dto, PHONE_NUMBER_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnFormatError_IfPhoneIsBadFormat() {

		dto.setContactPhone("66666666a");

		checkDTOHasError(dto, PHONE_NUMBER_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_NoReturnError_IfOrganisationIsCorrect() {

		dto.setOrganisation(CompleteDTOUtils.completeOrganisationDTO());

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_NoReturnError_IfPlatformTypeIsCorrect() {

		dto.setPlatformType(((PlatformTypeDTO) CompleteDTOUtils.completeObjectDomain(new PlatformTypeDTO())));

		checkDTOHasNoError(dto);
	}
}