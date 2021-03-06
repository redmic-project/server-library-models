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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.common.model.SearchWrapper;

public class GeoSearchWrapper<TProperties extends Properties, TGeometry extends Geometry> extends SearchWrapper {
	
	private GeoHitsWrapper<TProperties, TGeometry> hits;

	public GeoHitsWrapper<TProperties, TGeometry> getHits() {
		return hits;
	}

	public void setHits(GeoHitsWrapper<TProperties, TGeometry> hits) {
		this.hits = hits;
	}

	@JsonIgnore
	public Integer getTotal() {
		return getHits() != null ? getHits().getTotal() : 0;
	}

	@JsonIgnore
	public List<Feature<TProperties, TGeometry>> getSourceList() {
		return hits.getSourceList();
	}
	
	@JsonIgnore
	public Feature<TProperties, TGeometry> getSource(int index) {
		
		if (hits.getTotal() < 1)
			return null;
		return (Feature<TProperties, TGeometry>) hits.getHits().get(index).get_source();
	}
	
	@JsonIgnore
	public void setSource(int index, Feature<TProperties, TGeometry> source) {
		
		if (hits.getTotal() > index)
			hits.getHits().get(index).set_source(source);
	}
}
