/**
 * 
 */
package com.amrit.microservices.currencyconversionservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


import com.amrit.microservices.currencyconversionservice.bean.CurrencyConversionBean;

/**
 * @author amrit
 *
 */
//@FeignClient(name="currency-exchange-service", url="localhost:8000")
@FeignClient(name="netflix-zuul-api-gateway-server")
//@FeignClient(name="currency-exchange-service")
@RibbonClient("currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange-service/exchange-currency/{from}/to/{to}")
	//@GetMapping("/exchange-currency/{from}/to/{to}")
	public CurrencyConversionBean retrieveCurrencyExchange(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
