package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaUrl;

import es.redmic.models.es.common.deserializer.CustomRelationDeserializer;
import es.redmic.models.es.maintenance.taxonomy.dto.RankDTO;
import es.redmic.models.es.maintenance.taxonomy.dto.StatusDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxonBaseDTO extends TaxonCompactExtendedDTO {

	private Integer aphia;

	@JsonSchemaIgnore
	private Integer leaves = 0;

	@JsonIgnoreProperties(value = { "_meta" })
	@JsonSerialize(as = TaxonCompactExtendedDTO.class)
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.TAXONS")
	private TaxonDTO validAs;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.STATUS")
	private StatusDTO status;

	@JsonIgnoreProperties(value = { "_meta" })
	@NotNull
	@JsonDeserialize(using = CustomRelationDeserializer.class)
	@JsonSchemaUrl(value = "controller.mapping.SPECIES_RANK_SCHEMA")
	private RankDTO rank;

	public Integer getAphia() {
		return aphia;
	}

	public void setAphia(Integer aphia) {
		this.aphia = aphia;
	}

	public Integer getLeaves() {
		return leaves;
	}

	public void setLeaves(Integer leaves) {
		this.leaves = leaves;
	}

	public TaxonDTO getValidAs() {
		return validAs;
	}

	public void setValidAs(TaxonDTO validAs) {
		this.validAs = validAs;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public RankDTO getRank() {
		return rank;
	}

	@JsonSetter("rank")
	public void setRank(RankDTO rank) {
		this.rank = rank;
	}
}