package es.redmic.test.unit.series.objectcollecting.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.series.objectcollecting.dto.ObjectCollectingSeriesDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ObjectCollectingSeriesDTOTest extends DTOBaseTest<ObjectCollectingSeriesDTO> {

	private static ObjectCollectingSeriesDTO dto = new ObjectCollectingSeriesDTO();

	@Before
	public void reset() {
		
		dto = CompleteDTOUtils.completeObjectCollectingSeriesDTO();
		dto.setRemark("remark");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
	
	/*@Test
	public void validationDTO_ReturnNotNullError_IfObjectIsNull() {

		dto.setObject(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfObjectHasInsufficientLength() {

		dto.getObject().clear();

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}*/
	
	@Test
	public void validationDTO_ReturnNotNullError_IfValueIsNull() {

		dto.setValue(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
	
	@Test
	public void validationDTO_ReturnNotNullError_IfDateIsNull() {

		dto.setDate(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNoteExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}