package es.redmic.test.unit.administrative.taxonomy.dto;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import es.redmic.models.es.administrative.taxonomy.dto.WormsDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;
import es.redmic.test.utils.json.JsonToBeanTestUtil;

public class WormsDTOTest extends DTOBaseTest<WormsDTO> {

	private static WormsDTO dto = new WormsDTO();

	@Before
	public void reset() throws IOException {

		dto = (WormsDTO) JsonToBeanTestUtil.getBean("/worms/aphiaRecord.json", WormsDTO.class);
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfAphiaIsNull() {

		dto.setAphia(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfScientificnameIsNull() {

		dto.setScientificname(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfScientificnameExceedsSize() {

		dto.setScientificname(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfRankExceedsSize() {

		dto.setRank(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfStatusExceedsSize() {

		dto.setStatus(generateString(150));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfAuthorExceedsSize() {

		dto.setAuthority(generateString(200));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnSizeError_IfSynonymofExceedsSize() {

		dto.setValidName(generateString(200));

		checkDTOHasError(dto, SIZE_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUrlIsNull() {

		dto.setUrl(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfUrlIsNotValid() {

		dto.setUrl("pepe..es");

		checkDTOHasError(dto, URL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnNotNullError_IfModifiedIsNull() {

		dto.setModified(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void loadAphiaRecord_ReturnWormsDTO_IfFormatIsCorrect() throws IOException {

		WormsDTO result = (WormsDTO) JsonToBeanTestUtil.getBean("/worms/aphiaRecord.json", WormsDTO.class);

		assertEquals(result.getAphia().intValue(), 136470);
		assertEquals(result.getScientificname(), "Leptochelia dubia");
		assertEquals(result.getAuthority(), "(Kr\u00f8yer, 1842)");
		assertEquals(result.getModified().toString(), "2016-06-29T21:59:13.730Z");
		assertEquals(result.getRank(), "Species");
		assertEquals(result.getStatus(), "unaccepted");
		assertEquals(result.getUrl(), "http://www.marinespecies.org/aphia.php?p=taxdetails&id=136470");
		assertEquals(result.getValidAphia().toString(), "880865");
		assertEquals(result.getValidName(), "Chondrochelia dubia");
	}

	@Test
	public void loadAphiaRecordList_ReturnWormsDTOList_IfFormatIsCorrect() throws IOException {

		TypeReference<List<WormsDTO>> type = new TypeReference<List<WormsDTO>>() {
		};

		List<WormsDTO> result = JsonToBeanTestUtil.getBean("/worms/aphiaRecordList.json", type);

		assertEquals(result.size(), 3);
		assertEquals(result.get(0).getAphia().intValue(), 819866);
		assertEquals(result.get(1).getAphia().intValue(), 829015);
		assertEquals(result.get(2).getAphia().intValue(), 136470);
	}
}