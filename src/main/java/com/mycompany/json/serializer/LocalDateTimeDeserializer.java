package com.mycompany.json.serializer;

import java.io.IOException;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		
		try {
			return new LocalDateTime(jp.getText());
		} catch (IllegalArgumentException re) {
			throw ctxt.weirdStringException(jp.getText(), Period.class, "'" + jp.getText() + "' is not a valid representation of a LocalDateTime. " + re.getMessage());
		}
	}

}
