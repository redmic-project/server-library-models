package es.redmic.models.es.maintenance.objects.model;

import java.util.List;

import es.redmic.models.es.common.model.BaseAbstractES;

public class ObjectClassification extends BaseAbstractES {
	
	private String name;
	
	List<ObjectCollecting> classification;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ObjectCollecting> getClassification() {
		return classification;
	}
	
	public void setClassification(List<ObjectCollecting> classification) {
		this.classification = classification;
	}
}
