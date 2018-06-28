package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.OrganisationRoleDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class OrganisationRoleDTOTest extends DTOBaseTest<OrganisationRoleDTO> {

	private static OrganisationRoleDTO dto = new OrganisationRoleDTO();

	@Before
	public void reset() {

		dto.setOrganisation(CompleteDTOUtils.completeOrganisationDTO());

		dto.setRole(CompleteDTOUtils.completeRoleDTO());
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
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