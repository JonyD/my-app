package com.mycompany.openapi.v3.counter;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.json.serializer.LocalDateTimeDeserializer;
import com.mycompany.json.serializer.LocalDateTimeSerializer;
import com.mycompany.json.serializer.PeriodDeserializer;
import com.mycompany.json.serializer.PeriodSerializer;



public class ScenarioStatisticItem implements Comparable<ScenarioStatisticItem>{


	private LocalDateTime timespanBegin;


	private Period timespanDuration;


	private long scenarioCalls;


	private long deliveredRecommendations;


	public ScenarioStatisticItem(LocalDateTime timespanBegin, Period timespanDuration) {
		this.timespanBegin = timespanBegin;
		this.timespanDuration = timespanDuration;
	}


	@JsonSerialize(using=LocalDateTimeSerializer.class)
	public LocalDateTime getTimespanBegin() {
		return timespanBegin;
	}


	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	public void setTimespanBegin(LocalDateTime timespanBegin) {
		this.timespanBegin = timespanBegin;
	}


	@JsonSerialize(using=PeriodSerializer.class)
	public Period getTimespanDuration() {
		return timespanDuration;
	}


	@JsonDeserialize(using=PeriodDeserializer.class)
	public void setTimespanDuration(Period timespanDuration) {
		this.timespanDuration = timespanDuration;
	}


	public long getScenarioCalls() {
		return scenarioCalls;
	}


	public void setScenarioCalls(long scenarioCalls) {
		this.scenarioCalls = scenarioCalls;
	}


	public long getDeliveredRecommendations() {
		return deliveredRecommendations;
	}


	public void setDeliveredRecommendations(long deliveredRecommendations) {
		this.deliveredRecommendations = deliveredRecommendations;
	}


	@Override
	@SuppressWarnings("EQ_COMPARETO_USE_OBJECT_EQUALS")
	public int compareTo(ScenarioStatisticItem o2) {
		return timespanBegin.compareTo(o2.timespanBegin);
	}

}
