package es.redmic.models.es.atlas.dto;

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

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaFormat;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.constraintvalidate.url.ValidateUrl;
import es.redmic.models.es.common.dto.DTOImplement;

@JsonSchemaNotNull
public class ProtocolsDTO extends DTOImplement {

	@NotNull
	private String type;
	
	@JsonSchemaFormat("url")
	@ValidateUrl()
	@NotNull
	private String url;

	public ProtocolsDTO() {
	}
	
	public ProtocolsDTO(String type, String urlSource) {
		
		createProtocols(type, urlSource);
	}

	public void createProtocols(String type, String urlSource) {
		
		
		if (type == null || !type.equals("WMS"))
			return;
		
		setType(type);
		
		if (urlSource == null)
			return;
		
		setUrl(urlSource);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
