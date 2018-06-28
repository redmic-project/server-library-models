package es.redmic.models.es.common.request.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class CSVBaseDTO {

	private long id;
	private Boolean header = true;
	private Character separator = ';';
	private List<String> fields = new ArrayList<String>();
	
	Integer from = 0;
	Integer size = 100;
	
	public CSVBaseDTO() {
	}
	
	public Boolean getHeader() {
		return header;
	}

	public void setHeader(Boolean header) {
		this.header = header;
	}

	public Character getSeparator() {
		return separator;
	}

	public void setSeparator(Character separator) {
		this.separator = separator;
	}

	public List<String> getFields() {
		return fields;
	}
	
	@JsonIgnore
	public void setFields(String[] fields) {	
		this.fields = Arrays.asList(fields);
	}

	@JsonSetter("fields")
	public void setFields(List<FieldNameDTO> fields) {
		// TODO: quitar cuando desde javascript se envie un array de string
		List<String> nameFields = new ArrayList<String>();
		for (int i=0; i<fields.size(); i++)
			nameFields.add(fields.get(i).getType());
		this.fields = nameFields;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}
