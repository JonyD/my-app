package com.mycompany.json.serializer;

import java.io.IOException;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	private final DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis();

	@Override
	public void serialize(LocalDateTime value, JsonGenerator jgen, SerializerProvider provider)
				throws IOException, JsonProcessingException {

		if (value != null) {
			jgen.writeString(formatter.print(value));
		} else {
			jgen.writeNull();
		}

	}
}



