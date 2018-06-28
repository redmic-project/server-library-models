package es.redmic.models.es.common.deserializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.google.common.collect.Lists;

import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.models.es.common.view.JsonViewsForQueryDTO.ViewClassInterface;
import es.redmic.models.es.utils.JacksonFieldUtils;

public class CustomQueryDTODeserializer extends CustomObjectBaseDeserializer {

	@SuppressWarnings({ "unchecked", "serial" })
	@Override
	public Object deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		List<Field> fieldsNoIncludedInView = JacksonFieldUtils.getFieldsNoIncludedInView(targetClass,
				(Class<ViewClassInterface>) ctxt.getActiveView());

		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree(jp);

		List<String> fieldsToDeserialize = Lists.newArrayList(node.fieldNames());

		if (fieldsNoIncludedInView != null && fieldsNoIncludedInView.size() > 0) {

			if (fieldsToDeserialize == null || fieldsToDeserialize.size() == 0)
				try {
					return targetClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					System.out.println("Error creando instancia de la vista, " + targetClass);
					throw new InternalException(ExceptionType.INTERNAL_EXCEPTION, e);
				}

			for (Field field : fieldsNoIncludedInView) {
				if (fieldsToDeserialize.contains(field.getName())) {
					throw new UnrecognizedPropertyException(jp, "Propiedades no esperadas", null, targetClass,
							field.getName(), null);
				}
			}
		}

		List<String> ignorableFieldNames = new ArrayList<String>() {
			{
			}
		};

		for (String field : ignorableFieldNames) {
			if (fieldsToDeserialize.contains(field)) {
				throw new UnrecognizedPropertyException(jp, "Propiedades no esperadas", null, targetClass, field, null);
			}
		}

		ObjectMapper mapper = new ObjectMapper();

		mapper.setConfig(ctxt.getConfig());
		mapper.setConfig(
				mapper.getDeserializationConfig().withFeatures(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES));
		return mapper.readValue(node.traverse(), targetClass);
	}
}