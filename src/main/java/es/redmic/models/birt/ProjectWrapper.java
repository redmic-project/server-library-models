package es.redmic.models.birt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.administrative.dto.ActivityBaseDTO;
import es.redmic.models.es.administrative.dto.ActivityDTO;
import es.redmic.models.es.administrative.dto.ProjectDTO;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectWrapper extends Wrapper {

	private ProjectDTO project;
	private ActivityBaseDTO program;
	private List<ActivityDTO> activities;

	public ProjectWrapper() {
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public ActivityBaseDTO getProgram() {
		return program;
	}

	public void setProgram(ActivityBaseDTO program) {
		this.program = program;
	}

	public List<ActivityDTO> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityDTO> activities) {
		this.activities = activities;
	}
}