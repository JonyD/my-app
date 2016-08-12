package com.mycompany.openapi.v3.counter.jsons;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mycompany.openapi.v3.counter.EventsItem;
import com.mycompany.openapi.v3.counter.RevenueItem;
import com.mycompany.openapi.v3.model.ScenarioInfo;



/** Tests for {@link ScenarioInfo}. */
@Test
public class RevenueEventJsonTest {

		@Test(groups="fast")
	public void testJsonRevenueItem() throws JsonGenerationException, JsonMappingException, IOException {

		final LocalDateTime ld = new LocalDateTime(DateTimeZone.UTC);
		final Period pr = new Period();
		final RevenueItem revObj1 = new RevenueItem(ld,pr);
		final RevenueItem revObj2 = new RevenueItem(ld,pr);
		final ObjectMapper mapper = new ObjectMapper();

		// ===================== mine ===================
		String stringG1 = new Gson().toJson(revObj1);
		System.out.println("\n\nJDI:"+ stringG1);
		// =============================================

		StringWriter stringEmp = new StringWriter();
		mapper.writeValue(stringEmp, revObj1);
		System.out.println("\n\nJDI_emp:"+ stringG1);

		final String string1 = mapper.writeValueAsString(revObj1);
		final String string2 = mapper.writeValueAsString(revObj2);

		final StringTokenizer st1 = new StringTokenizer(string1,",");
		final StringTokenizer st2 = new StringTokenizer(string2,",");

		final Set<String> set1Strs = new HashSet<>();
		while (st1.hasMoreElements()) {
			set1Strs.add(st1.nextElement().toString());
		}
		final Set<String> set2Strs = new HashSet<>();
		while (st2.hasMoreElements()) {
			set2Strs.add(st2.nextElement().toString());
		}
		Assert.assertEquals(true, set1Strs.equals(set2Strs));
	}

	@Test(groups="fast")
	public void testJsonEventsItem() throws JsonGenerationException, JsonMappingException, IOException {

		final LocalDateTime ld=new LocalDateTime(DateTimeZone.UTC);
		final Period pr=new Period();
		final EventsItem eventObj1=new EventsItem(ld,pr);
		final EventsItem eventObj2=new EventsItem(ld,pr);

		final ObjectMapper mapper = new ObjectMapper();
		final String obj1 = mapper.writeValueAsString(eventObj1);
		final String obj2 = mapper.writeValueAsString(eventObj2);

		final StringTokenizer st1=new StringTokenizer(obj1,",");
		final StringTokenizer st2=new StringTokenizer(obj2,",");

		final Set<String> st1Strs=new HashSet<>();
		while (st1.hasMoreElements()) {
			st1Strs.add(st1.nextElement().toString());
		}
		final Set<String> st2Strs=new HashSet<>();
		while (st2.hasMoreElements()) {
			st2Strs.add(st2.nextElement().toString());
		}
		Assert.assertEquals(true, st1Strs.equals(st2Strs));

	}
}
