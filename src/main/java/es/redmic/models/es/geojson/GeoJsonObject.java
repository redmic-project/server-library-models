package es.redmic.models.es.geojson;

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

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoJsonObject {

	@JsonProperty("type")
	protected GeoJSONFeatureType geoJSONObjectType;

	private double[] bbox;

	public double[] getBbox() {
		return bbox;
	}

	public void setBbox(double[] bbox) {
		this.bbox = bbox;
	}

	public void setGeoJSONObjectType(GeoJSONFeatureType geoJSONObjectType) {
		this.geoJSONObjectType = geoJSONObjectType;
	}
}
