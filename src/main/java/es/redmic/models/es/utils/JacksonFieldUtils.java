package es.redmic.models.es.utils;

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