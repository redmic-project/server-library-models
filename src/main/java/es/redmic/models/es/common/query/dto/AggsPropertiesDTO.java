package es.redmic.models.es.common.query.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

public class AggsPropertiesDTO {

	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String field;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@NotNull
	String term;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	String nested;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	@JsonSchemaDefault("20")
	Integer size;
	
	@JsonView(value={JsonViewsForQueryDTO.Guest.class})
	Integer minCount = 0;

	public AggsPropertiesDTO() {
	}
	
	public AggsPropertiesDTO(String field) {
		setField(field);
	}
	
	public AggsPropertiesDTO(String field, String term) {
		setField(field);
		setTerm(term);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getNested() {
		return nested;
	}

	public void setNested(String nested) {
		this.nested = nested;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getMinCount() {
		return minCount;
	}

	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}
}