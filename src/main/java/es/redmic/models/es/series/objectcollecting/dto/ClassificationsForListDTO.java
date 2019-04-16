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

//TODO: cambiar a una base común para todas las clasificacioes, que se le pase el tipo del list. Ahora da problemas al pasarle el tipo al converter 
public class ClassificationsForListDTO {
	
	private List<ClassificationForListDTO> classification = new ArrayList<ClassificationForListDTO>();

	public List<ClassificationForListDTO> getClassification() {
		return classification;
	}

	public void setClassification(List<ClassificationForListDTO> classification) {
		this.classification = classification;
	}
}
