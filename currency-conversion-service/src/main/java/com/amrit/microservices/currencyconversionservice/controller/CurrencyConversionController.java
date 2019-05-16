/**
 * 
 */
package com.amrit.microservices.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.amrit.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.amrit.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author amrit
 *
 */
@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	/**
	 * 
	 */
	public CurrencyConversionController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/currency-conversion/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		String url = "http://localhost:8000/exchange-currency/{from}/to/{to}";
		Map<String, String> queryParamMap = new HashMap<String, String>();
		
		queryParamMap.put("from", from);
		queryParamMap.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> response = new RestTemplate().getForEntity(url, CurrencyConversionBean.class, queryParamMap);
		
		CurrencyConversionBean responseBean = new CurrencyConversionBean(
				response.getBody().getId(),
				response.getBody().getFrom(),
				response.getBody().getTo(),
				response.getBody().getConversionMultiple(),
				response.getBody().getPort(),
				quantity,
				quantity.multiply(response.getBody().getConversionMultiple()));
		return responseBean;
	}
	
	
	@GetMapping("/currency-conversion-feign/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFromFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		
		/*String url = "http://localhost:8000/exchange-currency/{from}/to/{to}";
		Map<String, String> queryParamMap = new HashMap<String, String>();
		
		queryParamMap.put("from", from);
		queryParamMap.put("to", to);*/
		
		CurrencyConversionBean response = proxy.retrieveCurrencyExchange(from, to);
				
				//new RestTemplate().getForEntity(url, CurrencyConversionBean.class, queryParamMap);
		
		CurrencyConversionBean responseBean = new CurrencyConversionBean(
				response.getId(),
				response.getFrom(),
				response.getTo(),
				response.getConversionMultiple(),
				response.getPort(),
				quantity,
				quantity.multiply(response.getConversionMultiple()));
		return responseBean;
	}

}
