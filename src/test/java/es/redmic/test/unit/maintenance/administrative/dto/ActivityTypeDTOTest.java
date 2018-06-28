package es.redmic.test.unit.maintenance.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.maintenance.administrative.dto.ActivityFieldDTO;
import es.redmic.models.es.maintenance.administrative.dto.ActivityTypeDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ActivityTypeDTOTest extends DTOBaseTest<ActivityTypeDTO> {
	
	private static ActivityTypeDTO dto = new ActivityTypeDTO();

	@Before
	public void reset() {

		dto.setName("name");
		dto.setName_en("name_en");
		dto.setActivityField((ActivityFieldDTO) CompleteDTOUtils.completeObjectDomain(new ActivityFieldDTO()));
		dto.setDescription("description");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfActivityFieldIsNull() {

		dto.setActivityField(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfDescriptionExceedsSize() {

		dto.setDescription(generateString(1500));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}
}