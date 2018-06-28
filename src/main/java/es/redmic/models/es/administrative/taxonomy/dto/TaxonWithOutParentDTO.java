package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

public class TaxonWithOutParentDTO extends TaxonBaseDTO {

	public TaxonWithOutParentDTO() {

	}

	// private String path;

	@Size(min = 0, max = 150)
	private String commonname;

	@JsonSchemaIgnore
	@Size(min = 0, max = 250)
	private String worms;

	@Size(min = 0, max = 1500)
	private String note;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSchemaIgnore
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime wormsUpdated;

	public String getCommonName() {
		return commonname;
	}

	public void setCommonName(String commonname) {
		this.commonname = commonname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getWorms() {
		return worms;
	}

	public void setWorms(String worms) {
		this.worms = worms;
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

	public DateTime getWormsUpdated() {
		return wormsUpdated;
	}

	public void setWormsUpdated(DateTime wormsUpdated) {
		this.wormsUpdated = wormsUpdated;
	}
}
