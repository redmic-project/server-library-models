package es.redmic.models.es.administrative.taxonomy.model;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
