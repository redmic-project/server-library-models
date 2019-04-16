package es.redmic.models.birt;

/*-
 * #%L
 * Models
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
