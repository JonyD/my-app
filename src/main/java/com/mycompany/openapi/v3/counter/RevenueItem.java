package com.mycompany.openapi.v3.counter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.json.serializer.CurrencyKeyDeserializer;
import com.mycompany.json.serializer.CurrencySerializerAsField;



/**
 * Extends v2 to provide all kinds of events that we store in the database
 *
 * @author johannes.hoerle
 *
 */
@JsonAutoDetect( fieldVisibility=Visibility.NON_PRIVATE,
				 getterVisibility=Visibility.PUBLIC_ONLY,
				 creatorVisibility=Visibility.NON_PRIVATE )
public class RevenueItem extends AbstractItem implements Comparable<RevenueItem>, Serializable {

	private long purchasedRecommended;
	private long deliveredRecommendations;
	private long recommendationCalls = 0;
	private PriceFormat priceFormat;
	private Map<Currency, BigDecimal> revenue = new HashMap<>();

	/** For Jackson */
	@Deprecated
	protected RevenueItem() {
		// nothing
	}


	public RevenueItem(LocalDateTime timespanStart, Period duration) {
		super.setTimespanBegin(timespanStart);
		super.setTimespanDuration(duration);
	}


	@JsonIgnore
	@Override
	public boolean isEmpty() {
		return super.isEmpty() &&
				purchasedRecommended == 0 &&
				deliveredRecommendations == 0 &&
				recommendationCalls == 0 &&
				(revenue == null || revenue.isEmpty());
	}


	@Override
	public String toString() {
		return getTimespanBegin() + "(" + getTimespanDuration() + "):C" + getClickEvents() + ",P" + getPurchaseEvents() + ",PR" + purchasedRecommended;
	}


	public long getRecommendationCalls() {
        return recommendationCalls;
    }


    public void setRecommendationCalls(long recommendationCalls) {
        this.recommendationCalls = recommendationCalls;
    }


    public long getDeliveredRecommendations() {
		return deliveredRecommendations;
	}
	public void setDeliveredRecommendations(long recommendedItems) {
		this.deliveredRecommendations = recommendedItems;
	}
	public void addDeliveredRecommendations(long toadd) {
		this.deliveredRecommendations += toadd;
	}

	public long getPurchasedRecommended() {
		return purchasedRecommended;
	}
	public void setPurchasedRecommended(long boughtRecommendations) {
		this.purchasedRecommended = boughtRecommendations;
	}
	public void addPurchasedRecommendations(long toadd) {
		this.purchasedRecommended += toadd;
	}


	@JsonSerialize(keyUsing=CurrencySerializerAsField.class, keyAs=String.class)
	public Map<Currency, BigDecimal> getRevenue() {
		return revenue;
	}


	@JsonDeserialize(keyUsing=CurrencyKeyDeserializer.class)
	public void setRevenue(Map<Currency, BigDecimal> revenue) {
		this.revenue = revenue;
	}


	public double getConversionRate() {
		if (recommendationCalls != 0) {
			double conversionRate = (double) super.getClickedRecommended() / this.recommendationCalls ;
	        return conversionRate;
		} else {
			return 0; // avoiding zero division.
		}
    }


	/** Does nothing. Created for Jackson */
	@Deprecated
	@SuppressWarnings("unused")
	protected void setConversionRate(double ignored) {
		// nothing
	}

	@Override
	@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("EQ_COMPARETO_USE_OBJECT_EQUALS")
	public int compareTo(RevenueItem o2) {
		return super.getTimespanBegin().compareTo(o2.getTimespanBegin());
	}

	public PriceFormat getPriceFormat() {
		return priceFormat;
	}

	public void setPriceFormat(PriceFormat priceFormat) {
		this.priceFormat = priceFormat;
	}

}
