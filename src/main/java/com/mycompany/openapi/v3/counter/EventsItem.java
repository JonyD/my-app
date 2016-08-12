package com.mycompany.openapi.v3.counter;

import java.io.Serializable;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;



/**
 * Extends v2 to provide all kinds of events that we store in the database
 * 
 * @author johannes.hoerle
 *
 */
@JsonAutoDetect(fieldVisibility=Visibility.NON_PRIVATE, getterVisibility=Visibility.PUBLIC_ONLY, creatorVisibility=Visibility.NON_PRIVATE)
public class EventsItem extends AbstractItem implements Serializable, Comparable<EventsItem> {
	
	
	/** For Jackson */
	@Deprecated
	protected EventsItem() {
		// nothing
	}
	
	
	public EventsItem(LocalDateTime timespanStart, Period duration) {
		super.setTimespanBegin(timespanStart);
		super.setTimespanDuration(duration);
	}
	
	/** Does nothing. Created for Jackson */
	@Deprecated
	@SuppressWarnings("unused")
	protected void setConversionRate(double ignored) {
		// nothing
	}
	
	
	@Override
	public String toString() {
		return getTimespanBegin() + "(" + getTimespanDuration() + "):C" + getClickEvents() + ",P" + getPurchaseEvents();
	}


	@Override
	@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EQ_COMPARETO_USE_OBJECT_EQUALS")
	public int compareTo(EventsItem o2) {
		return super.getTimespanBegin().compareTo(o2.getTimespanBegin());
	}
	
}
