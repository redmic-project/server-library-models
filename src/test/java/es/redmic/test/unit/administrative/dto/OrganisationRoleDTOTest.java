package es.redmic.test.unit.administrative.dto;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
