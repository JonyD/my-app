package com.mycompany.json.serializer;

import java.io.IOException;
import java.util.Currency;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/** Currency serializer for Jackson library.
 *
 *  Use in {@link JsonSerialize} annotation.
 *
 *  Use this field to serialize the J
 *
 */
public class CurrencySerializerAsField extends JsonSerializer<Currency> {

	@Override
	public void serialize(Currency value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		if (value != null) {
			jgen.writeFieldName(value.getCurrencyCode());
		} else {
			jgen.writeNull();
		}

	}
}