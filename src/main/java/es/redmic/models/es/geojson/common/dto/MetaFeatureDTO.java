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

import org.locationtech.jts.geom.Geometry;

import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaIgnore;

public abstract class MetaFeatureDTO<TProperties extends PropertiesDTO, TGeometry extends Geometry>
		extends FeatureDTO<TProperties, TGeometry> {

	public MetaFeatureDTO() {
		super();
		this._meta = new MetaDataFeatureDTO();
	}

	private String uuid;

	@JsonSchemaIgnore
	private MetaDataFeatureDTO _meta;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public MetaDataFeatureDTO get_meta() {
		return _meta;
	}

	public void set_meta(MetaDataFeatureDTO _meta) {
		this._meta = _meta;
	}

	@Override
	public void setProperties(TProperties properties) {
		super.setProperties(properties);
	}

	@Override
	public TProperties getProperties() {
		return super.getProperties();
	}
}
