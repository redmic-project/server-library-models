package es.redmic.models.es.geodata.misc.model;

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

import es.redmic.models.es.common.model.BaseAbstractES;
import es.redmic.models.es.geodata.ancillarydata.model.Analytic;
import es.redmic.models.es.geodata.ancillarydata.model.Metric;
import es.redmic.models.es.geodata.common.model.Media;
import es.redmic.models.es.geodata.genomics.model.Molecular;
import es.redmic.models.es.geodata.qualifiers.model.Attribute;

public class Element extends BaseAbstractES{
	
	private String registerNumber;
	
	private List<Media> media;

	private List<Analytic> analytics;
	
	private List<Attribute> attributes;
	
	private List<Metric> metrics;
	
	private List<Molecular> molecular;

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public List<Analytic> getAnalytics() {
		return analytics;
	}

	public void setAnalytics(List<Analytic> analytics) {
		this.analytics = analytics;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public List<Molecular> getMolecular() {
		return molecular;
	}

	public void setMolecular(List<Molecular> molecular) {
		this.molecular = molecular;
	}
}
