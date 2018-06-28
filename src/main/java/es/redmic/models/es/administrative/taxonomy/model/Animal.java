package es.redmic.models.es.administrative.taxonomy.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUniqueItemsByRequiredProperties;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class Animal extends AnimalCompact {

	private String note;
	private String description;
	private DomainES sex;
	private DomainES lifeStage;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;
	
	private DateTime releaseDate;
	private String releaseLocality;

	@JsonSchemaUniqueItemsByRequiredProperties
	private List<Recovery> recoveries;
	
	@JsonSchemaUniqueItemsByRequiredProperties
	private List<SpecimenTag> specimenTags;

	public Animal() {
		super();
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getReleaseDate() {
		return releaseDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setReleaseDate(DateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseLocality() {
		return releaseLocality;
	}

	public void setReleaseLocality(String releaseLocality) {
		this.releaseLocality = releaseLocality;
	}

	public List<Recovery> getRecoveries() {
		return recoveries;
	}

	public void setRecoveries(List<Recovery> recoveries) {
		this.recoveries = recoveries;
	}

	public List<SpecimenTag> getSpecimenTags() {
		return specimenTags;
	}

	public void setSpecimenTags(List<SpecimenTag> specimenTags) {
		this.specimenTags = specimenTags;
	}
}
