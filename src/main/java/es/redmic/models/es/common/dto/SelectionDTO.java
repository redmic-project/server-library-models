package es.redmic.models.es.common.dto;

import java.util.List;

public class SelectionDTO extends SelectionBaseDTO {

	List<String> ids;
	
	public SelectionDTO() {
	}
	
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
}
