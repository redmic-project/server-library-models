package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ActivityDocumentDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ActivityDocumentDTOTest extends DTOBaseTest<ActivityDocumentDTO> {

	private static ActivityDocumentDTO dto = new ActivityDocumentDTO();

	@Before
	public void beforeTest() {

		dto.setDocument(CompleteDTOUtils.completeDocumentDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfDocumentIsNull() {

		dto.setDocument(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}