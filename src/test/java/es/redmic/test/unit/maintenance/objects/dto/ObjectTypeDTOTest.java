package es.redmic.test.unit.maintenance.objects.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.objects.dto.ObjectTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DomainBaseDTOTest;

public class ObjectTypeDTOTest extends DomainBaseDTOTest<ObjectTypeDTO> {

	private static ObjectTypeDTO dto = new ObjectTypeDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeObjectTypeDTO();
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
	public void validationDTO_ReturnSizeError_IfCodeExceedsSize() {

		dto.setCode(generateString(50));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}