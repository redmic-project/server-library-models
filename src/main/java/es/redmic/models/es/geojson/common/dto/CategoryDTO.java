package es.redmic.models.es.geojson.common.dto;

import java.util.ArrayList;
import java.util.List;

import es.redmic.models.es.common.utils.HierarchicalUtils;

public class CategoryDTO {

	private List<Integer> divisions;
	
	private String field;
	
	private String target;
	
	private List<String> ids;

	public List<Integer> getDivisions() {
		return divisions;
	}

	public void setDivisions(List<Integer> divisions) {
		this.divisions = divisions;
	}
	
	public void addDivision(Integer division) {
		
		if (this.divisions == null)
			this.divisions = new ArrayList<Integer>();
		this.divisions.add(division);
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		
		for (int i=0; i<ids.size(); i++)
			addId(ids.get(i));
	}
	
	public void addId(String id) {
		
		if (this.ids == null)
			this.ids = new ArrayList<>();
		if (id.contains("."))
			this.ids.add(HierarchicalUtils.getIdFromPath(id));
		else
			this.ids.add(id);
	}
}