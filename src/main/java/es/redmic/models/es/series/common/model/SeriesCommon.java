package es.redmic.models.es.series.common.model;

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

import es.redmic.models.es.common.model.BaseAbstractES;

public abstract class SeriesCommon extends BaseAbstractES {
	
	private String _parentId;
	
	private String _grandparentId;

	private Character qFlag = '0';

	private Character vFlag = 'U';
	
	private String remark;
	
	public String get_parentId() {
		return _parentId;
	}

	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
	}
	
	public String get_grandparentId() {
		return _grandparentId;
	}
	
	public void set_grandparentId(String _grandparentId) {
		this._grandparentId = _grandparentId;
	}
	
	@JsonProperty(value="qFlag")
	public Character getQFlag() {
		return qFlag;
	}

	public void setQFlag(Character qFlag) {
		this.qFlag = qFlag;
	}

	@JsonProperty(value="vFlag")
	public Character getVFlag() {
		return vFlag;
	}

	public void setVFlag(Character vFlag) {
		this.vFlag = vFlag;
	}
	
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
