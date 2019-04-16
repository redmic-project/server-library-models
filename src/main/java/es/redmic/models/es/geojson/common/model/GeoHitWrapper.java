package es.redmic.models.es.geojson.common.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.HitWrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoHitWrapper<TProperties extends Properties, TGeometry extends Geometry> extends HitWrapper {

	private String _parent;

	private Feature<TProperties, TGeometry> _source;

	private InnerHits inner_hits;

	public String get_parent() {
		return _parent;
	}

	public void set_parent(String _parent) {
		this._parent = _parent;
	}

	public Feature<TProperties, TGeometry> get_source() {
		return _source;
	}

	public void set_source(Feature<TProperties, TGeometry> _source) {
		this._source = _source;
	}

	public InnerHits getInner_hits() {
		return inner_hits;
	}

	public void setInner_hits(InnerHits inner_hits) {
		this.inner_hits = inner_hits;
	}
}
