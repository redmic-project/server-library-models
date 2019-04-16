package es.redmic.models.es.geojson.wrapper;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.redmic.models.es.common.model.BaseES;
import es.redmic.models.es.common.model.HitWrapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoHitWrapper<TModel extends BaseES<?>> extends HitWrapper {

	private TModel _source;

	public TModel get_source() {
		return _source;
	}

	public void set_source(TModel _source) {
		this._source = _source;
	}
}
