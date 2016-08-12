package com.mycompany.json.serializer;

import java.io.IOException;

import org.joda.time.Period;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class PeriodDeserializer extends JsonDeserializer<Period> {
	@Override
	public Period deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonToken jsonToken = jsonParser.getCurrentToken();
        if (jsonToken == JsonToken.VALUE_STRING) {
            String text = jsonParser.getText().trim();
            try {
                return new Period(text);
            } catch (IllegalArgumentException iae) {
            	throw ctxt.mappingException(Period.class, jsonToken);
            }
        } else {
	        throw ctxt.mappingException(Period.class, jsonToken);
        }
	}
}
