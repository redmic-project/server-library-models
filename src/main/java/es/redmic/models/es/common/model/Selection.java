package es.redmic.models.es.common.model;

import java.util.List;

public class Selection extends Settings {

	List<String> ids;
	String service;

	public Selection() {
		
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
}
