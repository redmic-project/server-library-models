package es.redmic.models.es.administrative.taxonomy.model;

import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.model.UuidModel;

public class AnimalWithOutTaxon extends UuidModel {

	private String name;
	private String photo;
	private DomainES sex;
	private DomainES lifeStage;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public DomainES getSex() {
		return sex;
	}

	public void setSex(DomainES sex) {
		this.sex = sex;
	}

	public DomainES getLifeStage() {
		return lifeStage;
	}

	public void setLifeStage(DomainES lifeStage) {
		this.lifeStage = lifeStage;
	}
}
