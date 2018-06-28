package es.redmic.models.es.administrative.taxonomy.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.deserializer.CustomDateTimeDeserializer;
import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.common.model.DomainES;
import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;

@JsonSchemaNotNull
public class Recovery extends BaseAbstractES {

	private Long id;
	private DomainES ending;
	private DomainES destiny;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime admissionDate;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime releaseDate;
	private Integer convalescence;
	private String releasePlace;
	private String note;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;
	
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	public Recovery() {
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

	public DomainES getEnding() {
		return ending;
	}

	public void setEnding(DomainES ending) {
		this.ending = ending;
	}

	public DomainES getDestiny() {
		return destiny;
	}

	public void setDestiny(DomainES destiny) {
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}