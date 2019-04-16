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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.locationtech.jts.geom.Geometry;

import es.redmic.models.es.common.model.HitsWrapper;

public class GeoHitsWrapper<TProperties extends Properties, TGeometry extends Geometry> extends HitsWrapper {
	
	public GeoHitsWrapper() {
	}
	
	public GeoHitsWrapper(List<GeoHitWrapper<TProperties, TGeometry>> hits) {
		this.hits = hits;
	}
	
	private List<GeoHitWrapper<TProperties, TGeometry>> hits;

	public List<GeoHitWrapper<TProperties, TGeometry>> getHits() {
		return hits;
	}

	public void setHits(List<GeoHitWrapper<TProperties, TGeometry>> hits) {
		this.hits = hits;
	}
	
	@JsonIgnore
	public List<Feature<TProperties, TGeometry>> getSourceList() {
		
		List<Feature<TProperties, TGeometry>> sources = new ArrayList<Feature<TProperties, TGeometry>>();
		
		int total = getTotal();
		for(int i=0; i<total; i++) {
			if (hits.get(i) != null)
				sources.add(hits.get(i).get_source());
		}
		return sources;
	}
}
