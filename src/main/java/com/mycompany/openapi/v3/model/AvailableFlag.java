package com.mycompany.openapi.v3.model;

import javax.annotation.Nonnull;


/** Availability flag. Used to tag a scenario depended on the model builds for different
 *  item types. 
 * 
 *  @author rodion.alukhanov
 */
public enum AvailableFlag {
	
	AVAILABLE, PARTLY_AVAILABLE, NOT_AVAILABLE;
	
	
	
	/** Returns less available of two flags.
	 *  
	 *  @param a
	 *  	must be not <code>null</code>
	 *  @param b
	 * 		must be not <code>null</code>
	 *  @return
	 *  	never <code>null</code>.
	 */
	@Nonnull
	public static AvailableFlag lessAvailable(@Nonnull AvailableFlag a, @Nonnull AvailableFlag b) {
		if (a == null || b == null) {
			throw new NullPointerException("Both arguments must be not null.");
		}
		switch (a) {
			case AVAILABLE:
				return b;
			case PARTLY_AVAILABLE:
				return b == NOT_AVAILABLE ? NOT_AVAILABLE : PARTLY_AVAILABLE;
			case NOT_AVAILABLE:
				return NOT_AVAILABLE;
			default:
				throw new RuntimeException("Unexpected. Unknown value of AvaliableFlag: " + a + ".");
		}
	}
}
