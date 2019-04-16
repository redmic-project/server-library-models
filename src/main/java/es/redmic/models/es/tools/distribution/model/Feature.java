package es.redmic.models.es.tools.distribution.model;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.geojson.GeoJsonObject;


public class Feature<TProperties extends Properties, TGeometry extends Geometry> extends GeoJsonObject implements BaseES<Long> {

	private Long id;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private TProperties properties;

	@JsonInclude(JsonInclude.Include.ALWAYS)
	private TGeometry geometry;

	public void setProperties(TProperties properties) {
		this.properties = properties;
	}

	public TProperties getProperties() {
		return properties;
	}

	public TGeometry getGeometry() {
		return geometry;
	}

	public void setGeometry(TGeometry geometry) {
		this.geometry = geometry;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
