package es.redmic.models.es.common.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.query.dto.DataQueryDTO;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SelectionWorkDTO extends SelectionBaseDTO {

	DataQueryDTO query = new DataQueryDTO();

	String action;

	String userId;
	
	List<String> ids;
	
	String idProperty = "id";

	public SelectionWorkDTO() {
	}

	public DataQueryDTO getQuery() {
		return query;
	}

	public void setQuery(DataQueryDTO queryDTO) {
		this.query = queryDTO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
	public void addIds(List<String> ids) {
		this.ids.addAll(ids);
	}

	public String getIdProperty() {
		return idProperty;
	}

	public void setIdProperty(String idProperty) {
		this.idProperty = idProperty;
	}
}