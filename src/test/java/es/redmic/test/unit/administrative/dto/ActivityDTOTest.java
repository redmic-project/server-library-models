package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ActivityDTOTest extends DTOBaseTest<ActivityDTO> {

	private static ActivityDTO dto = new ActivityDTO();

	@Before
	public void beforeTest() {

		dto = CompleteDTOUtils.completeActivityDTO();
	}

	@Test
	public void validDto() {

		checkDTOHasNoError(dto);
	}
}