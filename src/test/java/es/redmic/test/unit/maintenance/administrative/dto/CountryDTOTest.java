package es.redmic.test.unit.maintenance.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.administrative.dto.CountryDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class CountryDTOTest extends DTOBaseTest<CountryDTO> {
	
	private static CountryDTO dto = new CountryDTO();

	@Before
	public void reset() {

		dto.setName("name");
		dto.setName_en("name_en");
		dto.setCode("co");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfCodeIsNull() {

		dto.setCode(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCodeExceedsSize() {

		dto.setCode(generateString(3));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}