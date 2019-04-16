package es.redmic.models.es.geojson.properties.model;

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

import es.redmic.models.es.geodata.misc.model.TimeSeriesInMeasurements;
import es.redmic.models.es.maintenance.parameter.model.DataDefinition;
import es.redmic.models.es.maintenance.parameter.model.Unit;
import es.redmic.models.es.series.common.model.HierarchicalParameterES;

public class Measurement {
	
	private TimeSeriesInMeasurements data;
	
	private DataDefinition dataDefinition;
	
	private HierarchicalParameterES parameter;
	
	private Unit unit;

	public TimeSeriesInMeasurements getData() {
		return data;
	}

	public void setData(TimeSeriesInMeasurements data) {
		this.data = data;
	}

	public DataDefinition getDataDefinition() {
		return dataDefinition;
	}

	public void setDataDefinition(DataDefinition dataDefinition) {
		this.dataDefinition = dataDefinition;
	}

	public HierarchicalParameterES getParameter() {
		return parameter;
	}

	public void setParameter(HierarchicalParameterES parameter) {
		this.parameter = parameter;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}
