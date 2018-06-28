package es.redmic.test.unit.maintenance.area.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.areas.dto.ThematicTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DomainBaseDTOTest;

public class ThematicTypeDTOTest extends DomainBaseDTOTest<ThematicTypeDTO> {

	private static ThematicTypeDTO dto = new ThematicTypeDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeThematicTypeDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setColour(generateString(7));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}