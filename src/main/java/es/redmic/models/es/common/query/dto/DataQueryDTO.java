package es.redmic.models.es.common.query.dto;

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

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;

import es.redmic.models.es.common.view.JsonViewsForQueryDTO;

@JsonFilter("DataQueryDTO")
@JsonSchemaNotNull
public class DataQueryDTO extends GeoDataQueryDTO {

	public DataQueryDTO() {
		super();
	}

	// Data
	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Size(max = 11)
	private List<String> qFlags;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Size(max = 5)
	private List<String> vFlags;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private DateLimitsDTO dateLimits;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	private String interval;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private ZRangeDTO z;

	@JsonView(value = { JsonViewsForQueryDTO.Guest.class })
	@Valid
	private List<ValueQueryDTO> value;

	public Boolean queryIsEmpty() {
		return ((getBbox() == null) && (getPostFilter() == null) && (getText() == null));
	}

	@JsonProperty("qFlags")
	public List<String> getQFlags() {
		return qFlags;
	}

	@JsonProperty("qFlags")
	public void setQFlags(List<String> qFlags) {
		this.qFlags = qFlags;
	}

	@JsonProperty("vFlags")
	public List<String> getVFlags() {
		return vFlags;
	}

	@JsonProperty("vFlags")
	public void setVFlags(List<String> vFlags) {
		this.vFlags = vFlags;
	}

	public DateLimitsDTO getDateLimits() {
		return dateLimits;
	}

	public void setDateLimits(DateLimitsDTO dateLimits) {
		this.dateLimits = dateLimits;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public ZRangeDTO getZ() {
		return z;
	}

	public void setZ(ZRangeDTO z) {
		this.z = z;
	}

	public List<ValueQueryDTO> getValue() {
		return value;
	}

	public void setValue(List<ValueQueryDTO> value) {
		this.value = value;
	}
}
