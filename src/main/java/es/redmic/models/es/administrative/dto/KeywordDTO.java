package es.redmic.models.es.administrative.dto;

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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import es.redmic.models.es.common.dto.CompactDTOImpl;

public class KeywordDTO extends CompactDTOImpl {

	@NotNull
	@Size(min = 1, max = 50)
	private String alias;

	@NotNull
	@Size(min = 1, max = 50)
	private String keyworden;

	@NotNull
	@Size(min = 1, max = 50)
	private String keywordsp;

	public KeywordDTO() {
		super();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getKeyworden() {
		return keyworden;
	}

	public void setKeyworden(String keyworden) {
		this.keyworden = keyworden;
	}

	public String getKeywordsp() {
		return keywordsp;
	}

	public void setKeywordsp(String keywordsp) {
		this.keywordsp = keywordsp;
	}
}
