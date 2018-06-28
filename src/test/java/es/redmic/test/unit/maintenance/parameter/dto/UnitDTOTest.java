package es.redmic.test.unit.maintenance.parameter.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.parameter.dto.UnitDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class UnitDTOTest extends DTOBaseTest<UnitDTO> {

	private static UnitDTO dto = new UnitDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeUnitDTO();
	}

	@Test
	public void validDto() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfName_enExceedsSize() {

		dto.setName_en(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAcronymExceedsSize() {

		dto.setAcronym(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUnitTypeIsNull() {

		dto.setUnitType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}