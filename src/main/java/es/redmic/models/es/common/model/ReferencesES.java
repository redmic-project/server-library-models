package es.redmic.models.es.common.model;

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

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.locationtech.jts.geom.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.exception.elasticsearch.ESUpdateException;
import es.redmic.jts4jackson.module.JTSModule;
import es.redmic.models.es.geojson.common.model.Properties;

@SuppressWarnings("rawtypes")
public class ReferencesES<TModel extends BaseES> {

	protected ObjectMapper objectMapper = new ObjectMapper().registerModule(new JTSModule())
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	private final Logger LOGGER = LoggerFactory.getLogger(ReferencesES.class);

	public ReferencesES(TModel oldModel, TModel newModel) {
		setOldModel(oldModel);
		setNewModel(newModel);

		if (!oldModel.getId().equals(newModel.getId())) {
			LOGGER.error("Intentando crear un referencesES con objetos con id diferentes");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}

	private TModel oldModel;
	private TModel newModel;
	private List<String> differences;
	private List<String> fieldsInReference = new ArrayList<String>();
	private Class<?> classFormMapping;

	private String initialPath = "";

	public TModel getOldModel() {
		return oldModel;
	}

	private void setOldModel(TModel oldModel) {
		this.oldModel = oldModel;
	}

	public TModel getNewModel() {
		return newModel;
	}

	private void setNewModel(TModel newModel) {
		this.newModel = newModel;
	}

	/**
	 * Función para obtener los campos que cambiaron entre modelos.
	 * 
	 */

	private void calculateDifferences() {

		compare(oldModel, newModel, initialPath);
	}

	/**
	 * Función para comparar los campos que cambiaron entre modelos. Los campos
	 * cambiados se almacenan en "differences"
	 * 
	 * @param oldModel
	 *            modelo de la referencia antes de ser modificada.
	 * @param newModel
	 *            nuevo modelo de la referencia con los cambios realizados.
	 * @param path
	 *            string que indica el path parcial del modelo que se va a comparar
	 *            (inicialmente vacio)
	 */

	private void compare(Object oldModel, Object newModel, String path) {

		if (fieldsInReference.size() == 0) {
			LOGGER.error("Intentando comparar modelos sin obtener los campos a indexar en la referencia.");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}

		BeanMap map = new BeanMap(oldModel);
		PropertyUtilsBean propUtils = new PropertyUtilsBean();

		for (Object propNameObject : map.keySet()) {
			String propertyName = (String) propNameObject;

			Object oldValue;
			Object newValue;
			try {
				oldValue = propUtils.getProperty(oldModel, propertyName);
				newValue = propUtils.getProperty(newModel, propertyName);

				String propertyPath = propertyName;

				if (path != null && path.length() > 0)
					propertyPath = path + "." + propertyName;
				if (oldValue != null && newValue != null && (oldValue instanceof BaseES
						|| oldValue instanceof Properties || oldValue instanceof Polygon))
					compare(oldValue, newValue, propertyPath);
				else if (((oldValue != null) && !oldValue.equals(newValue))
						|| ((newValue != null) && !newValue.equals(oldValue))) {
					getDifferences().add(propertyPath);
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

				LOGGER.info("Intentando acceder a la propiedad " + propertyName
						+ " y no existe. Esto puede deberse a que se trata de subclases.");

				if (fieldsInReference.contains(propertyName))
					throw new ESUpdateException(e);
			}
		}
	}

	/**
	 * @return Lista de campos que cambiaron en el modelo.
	 */
	public List<String> getDifferences() {

		if (differences == null) {
			differences = new ArrayList<String>();
			calculateDifferences();
		}
		return differences;
	}

	/**
	 * @return Clase con la que debe ser mapeada el modelo para indexarlo. Depende
	 *         de donde se vaya a indexar.
	 */

	public Class<?> getClassForMapping() {
		return classFormMapping;
	}

	public void setClassForMapping(Class<?> classFormMapping) {
		this.classFormMapping = classFormMapping;
		setFieldsInReference();
	}

	/**
	 * Función para obtener los campos de la clase con la que se va a mapear.
	 */

	private void setFieldsInReference() {

		calculateFieldsInReference(classFormMapping, initialPath);
	}

	/**
	 * Función para obtener los campos de la clase con la que se va a mapear. Los
	 * campos obtenidos se almacenan en "fieldsInReference"
	 * 
	 * @param resultClass
	 *            clase de donde se deben obtener los campos.
	 * @param path
	 *            string que indica el path parcial del modelo que se va a comparar
	 *            (inicialmente vacio)
	 */

	private void calculateFieldsInReference(Class<?> resultClass, String path) {

		if (resultClass.getGenericSuperclass() instanceof ParameterizedType) {
			Type superClassType = resultClass.getGenericSuperclass();
			calculateFieldsInReference((Class<?>) ((ParameterizedType) superClassType).getActualTypeArguments()[0],
					"properties");

		}
		while (resultClass != null && resultClass.getDeclaredFields() != null) {
			Field[] fields = resultClass.getDeclaredFields();
			for (int j = 0; j < fields.length; j++) {
				String propertyPath = fields[j].getName();

				if (path != null && path.length() > 0)
					propertyPath = path + "." + fields[j].getName();
				Type fieldType = fields[j].getType();
				if (!fields[j].isSynthetic()) {
					if (fields[j].getType().getName().contains("redmic") && !((Class<?>) fieldType).isEnum()) {
						fieldsInReference.add(propertyPath);
						calculateFieldsInReference((Class<?>) fieldType, propertyPath);
					} else
						fieldsInReference.add(propertyPath);
				}
			}
			resultClass = resultClass.getSuperclass();
		}
	}

	public void setFieldsInReference(List<String> fields) {
		fieldsInReference = fields;
	}

	public List<String> getFieldsInReference() {
		return fieldsInReference;
	}

	/**
	 * Función que indica si la referencia debe ser actualizada. Depende de si
	 * alguno de los campos de la clase han sido modificados.
	 * 
	 * @return true si debe ser actualizada, false en caso contrario.
	 */
	public Boolean needUpdate() {

		for (int i = 0; i < fieldsInReference.size(); i++)
			if (getDifferences().contains(fieldsInReference.get(i)))
				return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getModelToIndex() {

		try {
			String item = objectMapper.writerFor(classFormMapping).writeValueAsString(getNewModel());
			return objectMapper.readValue(item, Map.class);
		} catch (IOException e) {
			LOGGER.debug("Excepción al comparar referencias almacenadas");
			throw new ESUpdateException(e);
		}

	}
}
