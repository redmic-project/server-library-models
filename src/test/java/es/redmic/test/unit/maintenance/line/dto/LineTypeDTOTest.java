package es.redmic.test.unit.maintenance.line.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.line.dto.LineTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DomainBaseDTOTest;

public class LineTypeDTOTest extends DomainBaseDTOTest<LineTypeDTO> {

	private static LineTypeDTO dto = new LineTypeDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeLineTypeDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}