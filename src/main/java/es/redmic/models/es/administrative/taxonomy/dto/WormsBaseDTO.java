package es.redmic.models.es.administrative.taxonomy.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WormsBaseDTO {

	@NotNull
	private Integer aphia;

	@NotNull
	@Size(min = 1, max = 150)
	private String scientificname;

	@Size(min = 0, max = 150)
	private String rank;

	@JsonGetter("AphiaID")
	public Integer getAphia() {
		return aphia;
	}

	@JsonSetter("AphiaID")
	public void setAphia(Integer aphia) {
		this.aphia = aphia;
	}

	public String getScientificname() {
		return scientificname;
	}

	public void setScientificname(String scientificname) {
		this.scientificname = scientificname;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

}
