package com.mycompany.openapi.v3.model;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.openapi.v3.counter.ScenarioStatisticItem;



/** Base scenario information combined with statistic.
 *  It is used on the dashboard.
 *
 *  @author rodion.alukhanov
 */
@JsonAutoDetect(fieldVisibility=Visibility.NON_PRIVATE, getterVisibility=Visibility.PUBLIC_ONLY, creatorVisibility=Visibility.NON_PRIVATE)
public class ScenarioInfo {

	/** Scenario reference code. */
	@CheckForNull
	public String referenceCode;


	/** Scenario title. */
	@CheckForNull
	public String title;


	/** Scenario description. */
	@CheckForNull
	public String description;


	/** If the modes behind the scenario were built and be able to deliver recommendations. */
	@CheckForNull
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public AvailableFlag available;


	/** @deprecated For backward compatibility.
	 *  It is not used anymore. */
	@Deprecated
	@CheckForNull
	public EnabledFlag enabled = EnabledFlag.ENABLED;


	/** Scenario input item type. */
	@CheckForNull
	public Integer inputItemType;


	/** Output output item types. */
	@CheckForNull
	public int[] outputItemTypes;


	/** If scenario required the context. */
	@CheckForNull
	public ContextUsageFlag websiteContext;


	/** If scenario required the user history context. */
	@CheckForNull
	public ContextUsageFlag profileContext;


	/** If the scenario list was requested with statistic,
	 *  it contains the the statistic items.
	 */
	@CheckForNull
	@JsonInclude(Include.NON_NULL)
	public ScenarioStatisticItem[] statisticItems;


	/** Constructor */
	public ScenarioInfo(
			@Nonnull String referenceCode,
			@Nullable String title,
			@Nullable String description,
			@Nullable AvailableFlag avaliable,
			@Nonnull ContextUsageFlag websiteContext,
			@Nonnull ContextUsageFlag profileContext) {

		this.referenceCode = referenceCode;
		this.title = title;
		this.description = description;
		this.available = avaliable;
		this.websiteContext = websiteContext;
		this.profileContext = profileContext;
	}


	/** Backward compatibility. Same as {@link #available}. */
	@Deprecated
	public AvailableFlag getAvaliable() {
		return available;
	}


	/** Backward compatibility. Same as {@link #available}. */
	@Deprecated
	@SuppressWarnings("unused")
	public void setAvaliable(AvailableFlag avaliable) {
		// not used
	}


}
