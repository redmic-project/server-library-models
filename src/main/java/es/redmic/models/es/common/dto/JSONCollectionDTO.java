package es.redmic.models.es.common.dto;

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

public class JSONCollectionDTO extends JSONCollectionBaseDTO {

	@SuppressWarnings("rawtypes")
	protected List data;

	@SuppressWarnings("rawtypes")
	public JSONCollectionDTO() {
		super();
		data = new ArrayList();
		setTotal(0);
	}

	@SuppressWarnings("unchecked")
	public void addData(Object obj) {
		data.add(obj);
	}

	@SuppressWarnings("rawtypes")
	public List getData() {
		return data;
	}

	@SuppressWarnings("rawtypes")
	public void setData(List data) {
		this.data = data;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addAllData(List objs) {
		data.addAll(objs);
	}
}
