package es.redmic.models.es.administrative.taxonomy.dto;

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
