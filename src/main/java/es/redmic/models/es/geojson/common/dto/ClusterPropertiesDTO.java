package es.redmic.models.es.geojson.common.dto;

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

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.models.es.common.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.geojson.common.model.GeoPointData;
import es.redmic.models.es.geojson.tracking.common.point.ClusterPointPropertiesDTO;

public class ClusterPropertiesDTO extends ClusterPointPropertiesDTO {

	private DateTime startDate;
	private DateTime endDate;
	private ArrayList<String> uuids = new ArrayList<String>();

	public ClusterPropertiesDTO() {
		super();
	}
	
	public ClusterPropertiesDTO(GeoPointData feature) {
		addFeaturePropsInCluster(feature);
	}
	
	public void addUuid(String uuid) {
		uuids.add(uuid);
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public void addDate(DateTime date) {

		if (startDate == null || startDate.isAfter(date)) {
			startDate = date;
		}

		if (endDate == null || endDate.isBefore(date)) {
			endDate = date;
		}
	}

	public ArrayList<String> getUuids() {
		return uuids;
	}

	public void setUuids(ArrayList<String> uuids) {
		this.uuids = uuids;
	}

	public void addFeaturePropsInCluster(GeoPointData feature) {
		addDate(feature.getProperties().getInTrack().getDate());
		uuids.add(feature.getUuid());
		
	}
}
