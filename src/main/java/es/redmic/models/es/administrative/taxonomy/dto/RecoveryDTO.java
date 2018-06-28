package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.constraintvalidate.daterange.ValidateDateRange;
import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.common.dto.DTOImplement;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.maintenance.animal.dto.DestinyDTO;
import es.redmic.models.es.maintenance.animal.dto.EndingDTO;

@ValidateDateRange(start="admissionDate", end="releaseDate")
public class RecoveryDTO extends DTOImplement {

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.ENDING")
	private EndingDTO ending;

	@JsonIgnoreProperties(value = {"_meta"})
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value="controller.mapping.DESTINY")
	private DestinyDTO destiny;

	@NotNull
	private DateTime admissionDate;

	private DateTime releaseDate;

	private Integer convalescence;

	@Size(min = 0, max = 150)
	private String releasePlace;

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

	public RecoveryDTO() {
		super();
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getReleaseDate() {
		return releaseDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setReleaseDate(DateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public EndingDTO getEnding() {
		return ending;
	}

	public void setEnding(EndingDTO ending) {
		this.ending = ending;
	}

	public DestinyDTO getDestiny() {
		return destiny;
	}

	public void setDestiny(DestinyDTO destiny) {
		this.destiny = destiny;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getAdmissionDate() {
		return admissionDate;
	}

	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	public void setAdmissionDate(DateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	public Integer getConvalescence() {
		return convalescence;
	}

	public void setConvalescence(Integer convalescence) {
		this.convalescence = convalescence;
	}

	public String getReleasePlace() {
		return releasePlace;
	}

	public void setReleasePlace(String releasePlace) {
		this.releasePlace = releasePlace;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
}