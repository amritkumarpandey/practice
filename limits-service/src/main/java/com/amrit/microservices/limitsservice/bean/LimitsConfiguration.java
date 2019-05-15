/**
 * 
 */
package com.amrit.microservices.limitsservice.bean;

/**
 * @author amrit
 *
 */
public class LimitsConfiguration {
	private int maximumLimit;
	private int minimumLimit;
	/**
	 * @param maximumLimit
	 * @param minimumLimit
	 */
	public LimitsConfiguration(int maximumLimit, int minimumLimit) {
		super();
		this.maximumLimit = maximumLimit;
		this.minimumLimit = minimumLimit;
	}
	/**
	 * @return the maximumLimit
	 */
	public int getMaximumLimit() {
		return maximumLimit;
	}
	/**
	 * @param maximumLimit the maximumLimit to set
	 */
	public void setMaximumLimit(int maximumLimit) {
		this.maximumLimit = maximumLimit;
	}
	/**
	 * @return the minimumLimit
	 */
	public int getMinimumLimit() {
		return minimumLimit;
	}
	/**
	 * @param minimumLimit the minimumLimit to set
	 */
	public void setMinimumLimit(int minimumLimit) {
		this.minimumLimit = minimumLimit;
	}
	
	
}
