package com.mycompany.json.serializer;

import java.io.IOException;
import java.util.Currency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/** Currency key derializer for Jackson.
 *
 *  Use in {@link JsonDeserialize#keyUsing()} annotation.
 *
 */
public class CurrencyKeyDeserializer extends KeyDeserializer {

	@Override
	public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (key == null) {
            return null;
        }
        try {
            return Currency.getInstance(key);
            //return result;
        } catch (IllegalArgumentException re) {
            throw ctxt.weirdKeyException(Currency.class, key, "not a valid representation: "+re.getMessage());
        }
	}

}