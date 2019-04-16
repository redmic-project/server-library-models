package es.redmic.models.es.maintenance.parameter.model;

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

import java.util.ArrayList;
import java.util.List;

public class ParametersTimeSeries extends ParameterBase {
	
	private String path;

	private int leaves = 0;
	
	private List<DepthDefinitions> z;
	
	public ParametersTimeSeries() {
		z = new ArrayList<DepthDefinitions>();
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLeaves() {
		return leaves;
	}

	public void setLeaves(int leaves) {
		this.leaves = leaves;
	}

	public List<DepthDefinitions> getZ() {
		return z;
	}

	public void setZ(List<DepthDefinitions> z) {
		this.z = z;
	}
}
