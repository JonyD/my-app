package com.mycompany.json.serializer;

import java.io.IOException;

import org.joda.time.Period;
import org.joda.time.format.ISOPeriodFormat;
import org.joda.time.format.PeriodFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PeriodSerializer extends JsonSerializer<Period> {

	private final PeriodFormatter formatter = ISOPeriodFormat.standard();

	@Override
	public void serialize(Period value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		if (value != null) {
			jgen.writeString(formatter.print(value));
		} else {
			jgen.writeNull();
		}
	}
}