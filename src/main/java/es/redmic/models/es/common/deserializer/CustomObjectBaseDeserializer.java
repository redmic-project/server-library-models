package es.redmic.models.es.common.deserializer;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

import es.redmic.models.es.common.dto.BaseDTO;

public abstract class CustomObjectBaseDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

	protected Class<?> targetClass;
	
	@SuppressWarnings("unchecked")
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
			throws JsonMappingException {
		
		final JavaType type; 
	    if (property != null) 
	        type = property.getType();  // -> beanProperty is null when the StringConvertible type is a root value
	    else {
	        type = ctxt.getContextualType();
	    }
	    // ====  Get raw Class from type info  =====
	    targetClass = (Class<? extends BaseDTO<Long>>) type.getRawClass();
		return this;
	}
}
