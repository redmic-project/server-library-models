package es.redmic.test.unit.maintenance.point.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.point.dto.InfrastructureTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DomainBaseDTOTest;

public class InfrastructureTypeDTOTest extends DomainBaseDTOTest<InfrastructureTypeDTO> {

	private static InfrastructureTypeDTO dto = new InfrastructureTypeDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeInfrastructureTypeDTO();
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
}