/**
 * 
 */
package com.amrit.microservices.currencyexchangeservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.amrit.microservices.currencyexchangeservice.bean.ExchangeCurrency;

import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
/**
 * @author amrit
 *
 */
@RestController
public class CurrencyExchangeController {
	
	@GetMapping("/exchange-currency/{from}/to/{to}")
	public ExchangeCurrency retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return new ExchangeCurrency(1000L,from, to, new BigDecimal(70.23));
	}

}
