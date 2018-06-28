package es.redmic.models.es.administrative.dto;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.models.es.common.dto.CompactDTOImpl;

public class OrganisationCompactDTO extends CompactDTOImpl {

	@Size(min = 0, max = 50)
	private String acronym;

	@Size(min = 0, max = 250)
	private String logo;

	public OrganisationCompactDTO() {
		super();
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@JsonIgnore
	public String getCompactName() {
		return name;
	}
}
