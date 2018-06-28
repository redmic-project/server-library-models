package es.redmic.test.unit.maintenance.qualifiers.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.qualifiers.dto.AttributeTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DomainBaseDTOTest;

public class AttributeDTOTest extends DomainBaseDTOTest<AttributeTypeDTO> {

	private static AttributeTypeDTO dto = new AttributeTypeDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeAttributeTypeDTO();
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