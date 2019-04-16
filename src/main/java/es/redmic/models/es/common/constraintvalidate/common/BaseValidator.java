package es.redmic.models.es.common.constraintvalidate.common;

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

import java.lang.reflect.InvocationTargetException;

public abstract class BaseValidator<T extends Object> {

	private static final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];
	private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

	@SuppressWarnings("unchecked")
	protected static <T> T invokeDateGetter(Object obj, String methodName) {
		try {
			return (T) obj.getClass().getMethod(methodName, EMPTY_CLASS_ARRAY).invoke(obj, EMPTY_OBJECT_ARRAY);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | ClassCastException e) {
			throw new IllegalArgumentException("Unable to access " + obj.getClass().getName() + "#" + methodName, e);
		}
	}

	protected static String getAccessorMethodName(String property) {
		StringBuilder builder = new StringBuilder("get");
		builder.append(Character.toUpperCase(property.charAt(0)));
		builder.append(property.substring(1));
		return builder.toString();
	}
}
