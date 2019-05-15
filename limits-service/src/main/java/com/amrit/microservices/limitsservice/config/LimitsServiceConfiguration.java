/**
 * 
 */
package com.amrit.microservices.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author amrit
 *
 */
/*@Component*/
@ConfigurationProperties("limits-service")
public class LimitsServiceConfiguration {
	private int maxLimit;
	private int minLimit;
	
	public LimitsServiceConfiguration() {
		
	}
	/**
	 * @return the maxLimit
	 */
	public int getMaxLimit() {
		return maxLimit;
	}
	/**
	 * @param maxLimit the maxLimit to set
	 */
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	/**
	 * @return the minLimit
	 */
	public int getMinLimit() {
		return minLimit;
	}
	/**
	 * @param minLimit the minLimit to set
	 */
	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
	
	

}
