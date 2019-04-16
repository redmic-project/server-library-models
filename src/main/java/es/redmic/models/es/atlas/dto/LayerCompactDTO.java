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

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.atlas.LatLonBoundingBox;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;

public class LayerCompactDTO extends LayerCategoryDTO {
	
	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.THEME_INSPIRE")
	private ThemeInspireDTO themeInspire;
	
	@Valid
	private LatLonBoundingBox latLonBoundsImage;
	
	@JsonSchemaUniqueItemsByRequiredProperties
	@Valid
	@NotNull
	@Size(min=1)
	private List<ProtocolsDTO> protocols;
	
	public LayerCompactDTO() {
		this.protocols = new ArrayList<ProtocolsDTO>();
	}
	
	public ThemeInspireDTO getThemeInspire() {
		return themeInspire;
	}

	public void setThemeInspire(ThemeInspireDTO themeInspire) {
		this.themeInspire = themeInspire;
	}
	
	public LatLonBoundingBox getLatLonBoundsImage() {
		return latLonBoundsImage;
	}

	public void setLatLonBoundsImage(LatLonBoundingBox latLonBoundsImage) {
		this.latLonBoundsImage = latLonBoundsImage;
	}

	public List<ProtocolsDTO> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<ProtocolsDTO> protocols) {
		this.protocols = protocols;
	}
}
