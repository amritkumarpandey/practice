/**
 * 
 */
package com.amrit.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrit.microservices.limitsservice.bean.LimitsConfiguration;
import com.amrit.microservices.limitsservice.config.LimitsServiceConfiguration;
/**
 * @author amrit
 *
 */
@RestController
public class LimitsConfigurationController {

	@Autowired
	private LimitsServiceConfiguration limitsServiceConfiguration;
	@GetMapping("/limits")
	public LimitsConfiguration getLimitsConfiguration() {
		return new LimitsConfiguration(100,1);
	}
	
	@GetMapping("/config-limits")
	public LimitsConfiguration getLimitsFromConfiguration() {
		return new LimitsConfiguration(limitsServiceConfiguration.getMaxLimit(),limitsServiceConfiguration.getMinLimit());
	}
}
