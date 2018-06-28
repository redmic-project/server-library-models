package es.redmic.models.es.maintenance.statistics.dto;

import javax.validation.constraints.Min;

public class AdministrativeStatisticsDTO {

	private ResultDTO program;
	private ResultDTO project;
	private ResultDTO projectOutProgram;
	private ResultDTO activity;
	private ResultDTO activityOutProject;

	@Min(value = 0)
	private Integer organisation;

	@Min(value = 0)
	private Integer contact;

	@Min(value = 0)
	private Integer platform;

	@Min(value = 0)
	private Integer document;

	public AdministrativeStatisticsDTO() {

	}

	public ResultDTO getProgram() {
		return program;
	}

	public void setProgram(ResultDTO program) {
		this.program = program;
	}

	public ResultDTO getProject() {
		return project;
	}

	public void setProject(ResultDTO project) {
		this.project = project;
	}

	public ResultDTO getActivity() {
		return activity;
	}

	public void setActivity(ResultDTO activity) {
		this.activity = activity;
	}

	public Integer getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Integer organisation) {
		this.organisation = organisation;
	}

	public Integer getContact() {
		return contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public Integer getDocument() {
		return document;
	}

	public void setDocument(Integer document) {
		this.document = document;
	}

	public ResultDTO getProjectOutProgram() {
		return projectOutProgram;
	}

	public void setProjectOutProgram(ResultDTO projectOutProgram) {
		this.projectOutProgram = projectOutProgram;
	}

	public ResultDTO getActivityOutProject() {
		return activityOutProject;
	}

	public void setActivityOutProject(ResultDTO activityOutProject) {
		this.activityOutProject = activityOutProject;
	}
}
