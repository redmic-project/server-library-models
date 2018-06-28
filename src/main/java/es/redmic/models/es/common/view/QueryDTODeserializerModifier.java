package es.redmic.models.es.common.view;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;

import es.redmic.models.es.common.deserializer.CustomQueryDTODeserializer;
import es.redmic.models.es.common.query.dto.DataQueryDTO;
import es.redmic.models.es.common.query.dto.GeoDataQueryDTO;
import es.redmic.models.es.common.query.dto.MetadataQueryDTO;
import es.redmic.models.es.common.query.dto.SimpleQueryDTO;

public class QueryDTODeserializerModifier extends BeanDeserializerModifier {

	@Override
	public JsonDeserializer<?> modifyDeserializer(DeserializationConfig config, BeanDescription beanDesc,
			JsonDeserializer<?> deserializer) {
		
		if (isQueryDTO(beanDesc.getBeanClass())) {
			return new CustomQueryDTODeserializer();
		}
		return deserializer;
	}
	
	private boolean isQueryDTO(Class<?> type) {

		return (type.equals(DataQueryDTO.class) || type.equals(GeoDataQueryDTO.class)
				|| type.equals(MetadataQueryDTO.class) || type.equals(SimpleQueryDTO.class));
	}
}