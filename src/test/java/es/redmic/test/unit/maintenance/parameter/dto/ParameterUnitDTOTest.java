package es.redmic.test.unit.maintenance.parameter.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.parameter.dto.ParameterUnitDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ParameterUnitDTOTest extends DTOBaseTest<ParameterUnitDTO> {
	
	private static ParameterUnitDTO dto = new ParameterUnitDTO();

	@Before
	public void reset() {

		dto.setUnit(CompleteDTOUtils.completeUnitDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUnitIsNull() {

		dto.setUnit(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}