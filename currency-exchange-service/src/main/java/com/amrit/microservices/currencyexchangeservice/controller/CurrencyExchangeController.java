/**
 * 
 */
package com.amrit.microservices.currencyexchangeservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.amrit.microservices.currencyexchangeservice.bean.ExchangeCurrency;
import com.amrit.microservices.currencyexchangeservice.orm.ExchangeCurrencJPARepository;

import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author amrit
 *
 */
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private ExchangeCurrencJPARepository repository;
	
	@Autowired
	private Environment environment;
	@GetMapping("/exchange-currency/{from}/to/{to}")
	public ExchangeCurrency retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeCurrency exchangeCurrency = repository.findByFromAndTo(from, to);
				
				//new ExchangeCurrency(1000L,from, to, new BigDecimal(70.23));
		
		int localServerPort = Integer.parseInt(environment.getProperty("local.server.port"));
		exchangeCurrency.setPort(localServerPort);
		return exchangeCurrency;
	}

}
