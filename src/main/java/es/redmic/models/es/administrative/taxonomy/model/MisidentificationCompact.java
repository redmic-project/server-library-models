package es.redmic.models.es.administrative.taxonomy.model;

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

import es.redmic.models.es.administrative.model.DocumentCompact;
import es.redmic.models.es.common.model.BaseAbstractES;

public class MisidentificationCompact extends BaseAbstractES {

	DocumentCompact document;
	
	TaxonAncestorsCompact taxon;
	
	String note;

	public DocumentCompact getDocument() {
		return document;
	}

	public void setDocument(DocumentCompact document) {
		this.document = document;
	}

	public TaxonAncestorsCompact getTaxon() {
		return taxon;
	}

	public void setTaxon(TaxonAncestorsCompact taxon) {
		this.taxon = taxon;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
