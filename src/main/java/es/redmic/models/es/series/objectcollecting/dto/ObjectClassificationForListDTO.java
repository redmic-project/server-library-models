package es.redmic.models.es.series.objectcollecting.dto;

import java.util.ArrayList;
import java.util.List;

public class ObjectClassificationForListDTO {

	private String category;

	private List<ValueDTO> v = new ArrayList<ValueDTO>();
	
	private String path;

	private int leaves = 0;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<ValueDTO> getV() {
		return v;
	}

	public void setV(List<ValueDTO> v) {
		this.v = v;
	}
	
	public void initV(int size) {
		for (int i=0; i<size; i++)
			addV(0);
	}
	
	public void addV(Integer value) {
		
		ValueDTO itemValue = new ValueDTO();
		itemValue.setV(value);
		
		v.add(itemValue);
	
	}

	public void setV(Integer pos, Integer value) {
		
		ValueDTO itemValue = new ValueDTO();
		itemValue.setV(value);
		
		v.add(pos, itemValue);
		v.remove(v.size()-1);
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}
}
