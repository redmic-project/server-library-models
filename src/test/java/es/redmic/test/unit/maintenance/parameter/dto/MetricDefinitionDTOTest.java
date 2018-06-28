package es.redmic.test.unit.maintenance.parameter.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.ancillary.dto.MetricGroupDTO;
import es.redmic.models.es.maintenance.parameter.dto.MetricDefinitionDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class MetricDefinitionDTOTest extends DTOBaseTest<MetricDefinitionDTO> {

	private static MetricDefinitionDTO dto = new MetricDefinitionDTO();

	@Before
	public void reset() {

		dto = new MetricDefinitionDTO();
		dto.setName("name");
		dto.setDevice(CompleteDTOUtils.completeDeviceDTO());
		dto.setUnit(CompleteDTOUtils.completeUnitDTO());
		dto.setMetricGroup((MetricGroupDTO) CompleteDTOUtils.completeObjectDomain(new MetricGroupDTO()));
		dto.setDescription("description");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAcronymExceedsSize() {

		dto.setAcronym(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfMetricGroupIsNull() {

		dto.setMetricGroup(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDeviceIsNull() {

		dto.setDevice(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUnitIsNull() {

		dto.setUnit(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}