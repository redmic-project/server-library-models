package es.redmic.test.unit.maintenance.statistics.dto;

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

import es.redmic.models.es.maintenance.statistics.dto.ResultDTO;
import es.redmic.test.unit.common.dto.DTOBaseTest;

public class ResultDTOTest extends DTOBaseTest<ResultDTO> {
	
	private static ResultDTO dto = new ResultDTO();

	@Before
	public void reset() {

		dto = new ResultDTO();
	}

	@Test
	public void validDto() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void openNotValid() {

		dto.setOpen(-1);

		checkDTOHasError(dto, MIN_MESSAGE_TEMPLATE);
	}

	@Test
	public void closeNotValid() {

		dto.setClose(-1);

		checkDTOHasError(dto, MIN_MESSAGE_TEMPLATE);
	}

	@Test
	public void openValid() {

		dto.setOpen(1);

		checkDTOHasNoError(dto);
	}

	@Test
	public void closeValid() {

		dto.setClose(1);

		checkDTOHasNoError(dto);
	}
}
