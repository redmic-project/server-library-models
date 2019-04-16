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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaNotNull;
import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.common.dto.DTOImplement;
import es.redmic.models.es.geojson.GeoJSONFeatureType;

public class FeatureDTO<TProperties extends PropertiesBaseDTO, TGeometry extends Geometry> extends DTOImplement {

	@JsonSchemaIgnore
	protected GeoJSONFeatureType type;

	@JsonSchemaNotNull
	@NotNull
	@Valid
	private TProperties properties;

	@NotNull
	private TGeometry geometry;

	public FeatureDTO() {

	}

	public void setType(GeoJSONFeatureType type) {
		this.type = type;
	}

	public GeoJSONFeatureType getType() {
		return type;
	}

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

}
