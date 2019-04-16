package es.redmic.models.es.administrative.taxonomy.dto;

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

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.exception.databinding.FieldNotValidException;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.UuidDTO;

public class AnimalCompactDTO extends UuidDTO {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonSerialize(as = TaxonCompactExtendedDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.TAXONS")
	private TaxonDTO taxon;

	@Size(min = 0, max = 250)
	private String photo;

	@JsonIgnore
	public TaxonDTO getTaxon() {
		return taxon;
	}

	@JsonIgnore
	public void setTaxon(TaxonDTO taxon) {
		this.taxon = taxon;
	}

	@JsonIgnore
	public void setTaxonById(Long id) {
		if (id != null) {
			this.taxon = new TaxonDTO();
			this.taxon.setId(id);
		}
	}
	
	@JsonAnySetter
    public void parseUnknownProperties(String name, Object value) {
		if (name == "taxon") {
	    	if (value instanceof LinkedHashMap) {
	    		ObjectMapper mapper = new ObjectMapper();
	        	setTaxon(mapper.convertValue(value, TaxonDTO.class));
	    	} else if (value instanceof Long) {
	    		setTaxonById((Long) value);
	    	} else if (value instanceof Integer) {
	    		setTaxonById(new Long((int) value));
	    	} else {
	    		//throw new FieldNotValidException(name, (String) value);
	    	}
	    } else {
	    	// TODO - Habría que hacer una nueva excepción, porque el problema no es el valor sino el campo en si
	    	// Antes esto se frenaba sin entrar al DTO, pero con el jsonanysetter esto ya no lo frena
    		throw new FieldNotValidException(name, (String) value);
	    }
    }

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Size(min = 1, max = 50)
	public String getName() {
		return name;
	}
}
