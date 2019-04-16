package es.redmic.models.birt;

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
import java.util.Iterator;
import java.util.Map;

public class Birt {

	@SuppressWarnings("rawtypes")
	Iterator iterator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void open(Object appContext, Map params) {

		Map<String, Object> app = (Map<String, Object>) appContext;
		ArrayList items = (ArrayList) app.get("data");

		if (items == null)
			items = new ArrayList();

		iterator = items.iterator();
	}

	public Object next() {

		if (iterator.hasNext())
			return iterator.next();
		return null;
	}

	public void close() {

		iterator = null;
	}
}
