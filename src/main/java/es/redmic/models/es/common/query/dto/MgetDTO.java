package es.redmic.models.es.common.query.dto;

import java.util.List;

public class MgetDTO {
	
	public MgetDTO() {
	}
	
	public MgetDTO(List<String> ids) {
		this.ids = ids;
	}
	
	public MgetDTO(List<String> ids, List<String> fields) {
		this.ids = ids;
		this.fields = fields;
	}
	
	private List<String> ids;
	
	private List<String> fields;
	
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
