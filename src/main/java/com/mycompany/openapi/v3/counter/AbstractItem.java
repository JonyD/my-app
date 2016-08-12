
package com.mycompany.openapi.v3.counter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.OverridingMethodsMustInvokeSuper;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.json.serializer.LocalDateTimeDeserializer;
import com.mycompany.json.serializer.LocalDateTimeSerializer;
import com.mycompany.json.serializer.PeriodDeserializer;
import com.mycompany.json.serializer.PeriodSerializer;


public abstract class AbstractItem {


	private LocalDateTime timespanBegin;
	private Period timespanDuration;
	private long clickEvents;
	private long purchaseEvents;
	private long clickedRecommended;
	private long blacklistEvents;
	private long consumeEvents;
	private long rateEvents;
	private long ownsEvents;


	@JsonIgnore
	@OverridingMethodsMustInvokeSuper
	public boolean isEmpty() {
		return
			clickEvents == 0 &&
			purchaseEvents == 0 &&
			clickedRecommended == 0 &&
			blacklistEvents == 0 &&
			consumeEvents == 0 &&
			rateEvents == 0 &&
			ownsEvents == 0;
	}


	public static <T extends AbstractItem> List<T> filterNonEmpty(Collection<T> items) {
		List<T> result = new ArrayList<>();
		for (T item : items) {
			if ( ! item.isEmpty()) {
				result.add(item);
			}
		}
		return result;
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

	public long getClickEvents() {
		return clickEvents;
	}

	public void setClickEvents(long clickEvents) {
		this.clickEvents = clickEvents;
	}

	public long getPurchaseEvents() {
		return purchaseEvents;
	}

	public void setPurchaseEvents(long purchaseEvents) {
		this.purchaseEvents = purchaseEvents;
	}

	public long getClickedRecommended() {
		return clickedRecommended;
	}

	public void setClickedRecommended(long clickedRecommended) {
		this.clickedRecommended = clickedRecommended;
	}

	public long getBlacklistEvents() {
		return blacklistEvents;
	}

	public void setBlacklistEvents(long blacklistEvents) {
		this.blacklistEvents = blacklistEvents;
	}

	public long getConsumeEvents() {
		return consumeEvents;
	}

	public void setConsumeEvents(long consumeEvents) {
		this.consumeEvents = consumeEvents;
	}

	public long getRateEvents() {
		return rateEvents;
	}

	public void setRateEvents(long rateEvents) {
		this.rateEvents = rateEvents;
	}

	public long getOwnsEvents() {
		return ownsEvents;
	}

	public void setOwnsEvents(long ownsEvents) {
		this.ownsEvents = ownsEvents;
	}
	public void addClickEvents(long toadd) {
		this.clickEvents += toadd;
	}
	public void addPurchaseEvents(long toadd) {
		this.purchaseEvents += toadd;
	}
	public void addClickedRecommendations(int toadd) {
		this.clickedRecommended += toadd;
	}
	public void addBlacklistEvents(long toadd) {
		this.blacklistEvents += toadd;
	}
	public void addConsumeEvents(long toadd) {
		this.consumeEvents += toadd;
	}
	public void addRateEvents(long toadd) {
		this.rateEvents += toadd;
	}

	public void addOwnsEventsEvents(long toadd) {
		this.ownsEvents += toadd;
	}



}
