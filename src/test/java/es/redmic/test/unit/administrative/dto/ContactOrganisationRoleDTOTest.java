package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ContactOrganisationRoleDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ContactOrganisationRoleDTOTest extends DTOBaseTest<ContactOrganisationRoleDTO> {
	
	private static ContactOrganisationRoleDTO dto = new ContactOrganisationRoleDTO();

	@Before
	public void reset() {

		dto.setContact(CompleteDTOUtils.completeContactDTO());
		dto.setOrganisation(CompleteDTOUtils.completeOrganisationDTO());
		dto.setRole(CompleteDTOUtils.completeRoleDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfContactIsNull() {

		dto.setContact(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfOrganisationIsNull() {

		dto.setOrganisation(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfRoleIsNull() {

		dto.setRole(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}