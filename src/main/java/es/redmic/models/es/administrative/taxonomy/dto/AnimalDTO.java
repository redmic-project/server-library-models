package es.redmic.models.es.administrative.taxonomy.dto;

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

import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.animal.dto.LifeStageDTO;
import es.redmic.models.es.maintenance.animal.dto.SexDTO;

public class AnimalDTO extends AnimalCompactDTO {

	@Size(min = 0, max = 1500)
	private String note;

	@Size(min = 0, max = 1500)
	private String description;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.SEX")
	private SexDTO sex;

	@JsonIgnoreProperties(value = {"_meta"})
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.LIFE_STAGE")
	private LifeStageDTO lifeStage;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	private DateTime releaseDate;

	@Size(min = 0, max = 150)
	private String releaseLocality;

	private List<RecoveryDTO> recoveries;

	private List<SpecimenTagDTO> specimenTags;

	public AnimalDTO() {
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

	public SexDTO getSex() {
		return sex;
	}

	public void setSex(SexDTO sex) {
		this.sex = sex;
	}

	public LifeStageDTO getLifeStage() {
		return lifeStage;
	}

	public void setLifeStage(LifeStageDTO lifeStage) {
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

	public List<RecoveryDTO> getRecoveries() {
		return recoveries;
	}

	public void setRecoveries(List<RecoveryDTO> recoveries) {
		this.recoveries = recoveries;
	}

	public List<SpecimenTagDTO> getSpecimenTags() {
		return specimenTags;
	}

	public void setSpecimenTags(List<SpecimenTagDTO> specimenTags) {
		this.specimenTags = specimenTags;
	}
}
