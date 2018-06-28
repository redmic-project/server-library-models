package es.redmic.models.es.administrative.model;

public class OrganisationContactRoles extends ContactRoles {

	private OrganisationCompact organisation;

	public OrganisationCompact getOrganisation() {
		return organisation;
	}

	public void setOrganisation(OrganisationCompact organisation) {
		this.organisation = organisation;
	}
}
