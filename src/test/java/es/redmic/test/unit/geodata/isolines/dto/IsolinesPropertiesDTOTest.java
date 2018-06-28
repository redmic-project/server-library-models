package es.redmic.test.unit.geodata.isolines.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.geojson.isolines.dto.IsolinesPropertiesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class IsolinesPropertiesDTOTest extends DTOBaseTest<IsolinesPropertiesDTO> {

	private static IsolinesPropertiesDTO dto = new IsolinesPropertiesDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeIsolinesPropertiesDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDataDefinitionIsNull() {

		dto.setDataDefinition(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	// @Test
	public void validationDTO_ReturnNotNullError_IfActivityIsNull() {

		dto.setActivityId(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfLineTypeIsNull() {

		dto.setLineType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUnitIsNull() {

		dto.setUnit(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfParameterIsNull() {

		dto.setParameter(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}