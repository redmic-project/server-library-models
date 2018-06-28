package es.redmic.models.es.common.dto;

import java.util.ArrayList;
import java.util.List;

public class JSONCollectionDTO extends JSONCollectionBaseDTO {

	@SuppressWarnings("rawtypes")
	protected List data;

	@SuppressWarnings("rawtypes")
	public JSONCollectionDTO() {
		super();
		data = new ArrayList();
		setTotal(0);
	}

	@SuppressWarnings("unchecked")
	public void addData(Object obj) {
		data.add(obj);
	}

	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}

	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addAllData(List objs) {
		data.addAll(objs);
	}
}
