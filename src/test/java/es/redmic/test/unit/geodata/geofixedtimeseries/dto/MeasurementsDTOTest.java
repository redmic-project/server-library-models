package es.redmic.test.unit.geodata.geofixedtimeseries.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.series.common.dto.MeasurementDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class MeasurementsDTOTest extends DTOBaseTest<MeasurementDTO> {
	
	private static MeasurementDTO dto = new MeasurementDTO();

	@Before
	public void reset() {

		dto = new MeasurementDTO();
		dto.setDataDefinition(CompleteDTOUtils.completeDataDefinitionSeries());
		dto.setParameter(CompleteDTOUtils.completeHierarchicalParameter());
		dto.setUnit(CompleteDTOUtils.completeUnitDTO());
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
	
	@Test
	public void validationDTO_ReturnNotNullError_IfParameterIsNull() {

		dto.setParameter(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfUnitIsNull() {

		dto.setUnit(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}