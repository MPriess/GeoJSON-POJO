
package org.geojson.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.geojson.object.Feature;

/**
 * Simple helper to facilitate deserialization of {@link Feature#properties} using the default serializer, thus escaping Jackson complain of trying to instantiate interface
 * 
 * {@link java.io.Serializable}.
 *
 * @author kenny
 */
public class FeaturePropertiesDeserializer extends JsonDeserializer<Map<String, Serializable>>{

	@Override
	public Map<String, Serializable> deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		return new HashMap<>();
	}
	
}
