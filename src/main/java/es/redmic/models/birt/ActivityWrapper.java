package es.redmic.models.birt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.administrative.dto.ActivityBaseDTO;
import es.redmic.models.es.administrative.dto.ActivityDTO;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityWrapper extends Wrapper {

	private ActivityDTO activity;
	private ActivityBaseDTO project;
	private ActivityBaseDTO program;

	public ActivityWrapper() {
	}

	public ActivityDTO getActivity() {
		return activity;
	}

	public void setActivity(ActivityDTO activity) {
		this.activity = activity;
	}

	public ActivityBaseDTO getProject() {
		return project;
	}

	public void setProject(ActivityBaseDTO project) {
		this.project = project;
	}

	public ActivityBaseDTO getProgram() {
		return program;
	}

	public void setProgram(ActivityBaseDTO program) {
		this.program = program;
	}
}