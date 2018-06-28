package es.redmic.models.birt;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.administrative.dto.ProgramDTO;

/**
 * @author oag
 * @version 1.0
 * @created 09-jun-2015 14:17:32
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramWrapper extends Wrapper {

	private ProgramDTO program;
	private List<ProjectWrapper> projectWrappers;

	public ProgramWrapper() {
	}

	public ProgramDTO getProgram() {
		return program;
	}

	public void setProgram(ProgramDTO program) {
		this.program = program;
	}

	public List<ProjectWrapper> getProjectWrappers() {
		return projectWrappers;
	}

	public void setProjectWrappers(List<ProjectWrapper> projectWrappers) {
		this.projectWrappers = projectWrappers;
	}

}