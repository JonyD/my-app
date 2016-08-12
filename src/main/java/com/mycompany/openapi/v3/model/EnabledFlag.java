package com.mycompany.openapi.v3.model;

public enum EnabledFlag {

	/** No recommendations. No building. */
	DISABLED, 
	
	/** Scenarios models must be build, but the scenario cannot be used to generate
	 *  recommendation. */ 
	BUILD_ONLY, 
	
	/** Scenario generated recommendations and the scenarios models must be build. */
	ENABLED;
	
}
