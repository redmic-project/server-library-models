package es.redmic.models.es.series.objectcollecting.dto;

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

public class ClassificationForListDTO extends ClassificationBaseDTO {
	
	private List<ValueDTO> v = new ArrayList<ValueDTO>();
	
	private List<ObjectClassificationForListDTO> data = new ArrayList<ObjectClassificationForListDTO>();
	
	private Header header = new Header();
	
	public ClassificationForListDTO() {
	
	}
	
	public List<ValueDTO> getV() {
		return v;
	}

	public void setV(List<ValueDTO> v) {
		this.v = v;
	}

	public void addV(Integer value) {
		
		ValueDTO itemValue = new ValueDTO();
		itemValue.setV(value);
		v.add(itemValue);
	}

	public List<ObjectClassificationForListDTO> getData() {
		return data;
	}

	public void setData(List<ObjectClassificationForListDTO> data) {
		this.data = data;
	}
	
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	@JsonIgnore
	public int addHeader(String value) {
		return header.addDates(value);
	}
	
	public int getHeaderPos(String value) {
		return header.indexOf(value);
	}
	
	@JsonIgnore
	public int getHeaderSize() {
		return header.size();
	}

	/** 
	 * Cabecera para el listado
	 * */

	public class Header {
		
		private List<Label> dates = new ArrayList<>();
		
		public int addDates(String value) {
			
			Label label = new Label();
			label.setLabel(value);
			
			if (!dates.contains(label))
				dates.add(label);
			return dates.indexOf(label);
		}
		
		public int indexOf(String value) {
			
			Label label = new Label();
			label.setLabel(value);
			return dates.indexOf(label);
		}
		
		public List<Label> getDates() {
			return dates;
		}
		
		public void setDates(List<Label> dates) {
			this.dates = dates;
		}
		
		public int size() {
			return dates.size();
		}
		
		public class Label {
			private String label;

			public String getLabel() {
				return label;
			}

			public void setLabel(String label) {
				this.label = label;
			}
			
			@Override
			public boolean equals(Object obj) {
				Label item = (Label) obj;
				return this.getLabel().equals(item.getLabel());
			}
		}
	}
}
