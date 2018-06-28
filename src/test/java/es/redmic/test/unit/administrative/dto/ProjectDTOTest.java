package es.redmic.test.unit.administrative.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.administrative.dto.ProjectDTO;
import es.redmic.test.unit.common.dto.CompleteDTOUtils;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ProjectDTOTest extends DTOBaseTest<ProjectDTO> {
	
	private static ProjectDTO dto = new ProjectDTO();

	@Before
	public void reset() {

		dto = CompleteDTOUtils.completeProjectDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}
}