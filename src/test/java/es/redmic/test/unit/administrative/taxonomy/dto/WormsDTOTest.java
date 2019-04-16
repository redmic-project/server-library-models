package es.redmic.test.unit.administrative.taxonomy.dto;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		assertNotNull(result.get(0).getModified());
		assertEquals(result.get(1).getAphia().intValue(), 829015);
		assertNotNull(result.get(1).getModified());
		assertEquals(result.get(2).getAphia().intValue(), 136470);
		assertNotNull(result.get(2).getModified());
	}
}
