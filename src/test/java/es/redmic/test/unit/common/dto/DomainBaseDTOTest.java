package es.redmic.test.unit.common.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.models.es.common.dto.DomainImplDTO;

@SuppressWarnings("unchecked")
public abstract class DomainBaseDTOTest<TDTO extends DomainImplDTO> extends DTOBaseTest<TDTO> {
	
	protected static DomainImplDTO dto = new DomainImplDTO();
	
	@Before
	public void beforeTest() {

		dto.setName("name");
		dto.setName_en("name_en");
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError((TDTO) dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfNameIsNull() {

		dto.setName(null);

		checkDTOHasError((TDTO) dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfNameExceedsSize() {

		dto.setName(generateString(150));

		checkDTOHasError((TDTO) dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfName_enIsNull() {

		dto.setName_en(null);

		checkDTOHasError((TDTO) dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfName_enExceedsSize() {

		dto.setName_en(generateString(150));

		checkDTOHasError((TDTO) dto, SIZE_MESSAGE_TEMPLATE);
	}
}