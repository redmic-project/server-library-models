package es.redmic.models.es.utils;

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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.fasterxml.jackson.annotation.JsonView;

import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO.ViewClassInterface;

public abstract class JacksonFieldUtils {

	public static final Set<String> getFieldNamesNoIncludedInView(Class<?> sourceClass,
			Class<ViewClassInterface> viewClass) {

		List<Field> fields = getFieldsNoIncludedInView(sourceClass, viewClass);

		Set<String> fieldNames = new HashSet<String>();

		for (Field field : fields) {
			fieldNames.add(field.getName());
		}
		return fieldNames;
	}

	@SuppressWarnings("unchecked")
	public static final List<Field> getFieldsNoIncludedInView(Class<?> sourceClass,
			Class<ViewClassInterface> viewClass) {

		List<Field> fieldsNoIncludedInView = new ArrayList<>();

		if (viewClass == null)
			return fieldsNoIncludedInView;

		ViewClassInterface viewClassInstance;

		try {
			viewClassInstance = viewClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION, e);
		}

		Field[] fields = FieldUtils.getAllFields(sourceClass);

		for (Field field : fields) {
			if (!field.isAnnotationPresent(JsonView.class)) {
				fieldsNoIncludedInView.add(field);
			} else {
				JsonView annotation = field.getAnnotation(JsonView.class);
				Class<ViewClassInterface> annotationView = (Class<ViewClassInterface>) Arrays.asList(annotation.value())
						.get(0);

				if (!viewClassInstance.isAuthorized(annotationView)) {
					fieldsNoIncludedInView.add(field);
				}
			}
		}
		return fieldsNoIncludedInView;
	}
}
