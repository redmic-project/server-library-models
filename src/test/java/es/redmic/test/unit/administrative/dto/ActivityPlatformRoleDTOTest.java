package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ActivityPlatformRoleDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ActivityPlatformRoleDTOTest extends DTOBaseTest<ActivityPlatformRoleDTO> {
	
	private static ActivityPlatformRoleDTO dto = new ActivityPlatformRoleDTO();

	@Before
	public void reset() {

		dto.setPlatform(CompleteDTOUtils.completePlatformDTO());
		dto.setContact(CompleteDTOUtils.completeContactDTO());
		dto.setRole(CompleteDTOUtils.completeRoleDTO());
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfPlatformIsNull() {

		dto.setPlatform(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfContactIsNull() {

		dto.setContact(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfContactRoleIsNull() {

		dto.setRole(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}