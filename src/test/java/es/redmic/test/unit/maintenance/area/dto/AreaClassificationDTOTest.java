package es.redmic.test.unit.maintenance.area.dto;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.areas.dto.AreaClassificationDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class AreaClassificationDTOTest extends DTOBaseTest<AreaClassificationDTO> {

	private static AreaClassificationDTO dto = new AreaClassificationDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeAreaClassificationDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	// @Test
	public void validationDTO_ReturnNotNullError_IfActivityIsNull() {

		dto.setType(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnValidateDateRangeError_IfEndDateGreatThanStartDate() {

		dto.setEndDate(new DateTime("2014-03-17T00:00:00.000Z"));

		checkDTOHasError(dto, DATE_RANGE_MESSAGE_TEMPLATE);
	}

	@SuppressWarnings("serial")
	@Test
	public void validationDTO_ReturnValidateDateRangeError_IfStartDateIsNullAndEndDateIsNotNull() {

		dto.setEndDate(new DateTime("2014-03-17T00:00:00.000Z"));
		dto.setStartDate(null);

		checkDTOHasError(dto, new ArrayList<String>() {
			{
				add(DATE_RANGE_MESSAGE_TEMPLATE);
			}
		});
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setRemark(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}