package es.redmic.test.unit.administrative.dto;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ActivityBaseDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ActivityBaseDTOTest extends DTOBaseTest<ActivityBaseDTO> {

	private static ActivityBaseDTO dto = new ActivityBaseDTO();
	
	@Before
	public void beforeTest() {

		dto = CompleteDTOUtils.completeActivityBaseDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfNameIsNull() {

		dto.setName(null);

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

		checkDTOHasError(dto, new ArrayList<String>() {{
			add(DATE_RANGE_MESSAGE_TEMPLATE);
			add(NOT_NULL_MESSAGE_TEMPLATE);
		}});
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(510));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameHasInsufficientLength() {

		dto.setName("");

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfAccessibilityIsNull() {

		dto.setAccessibility(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfCodeExceedsSize() {

		dto.setCode(generateString(25));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

}