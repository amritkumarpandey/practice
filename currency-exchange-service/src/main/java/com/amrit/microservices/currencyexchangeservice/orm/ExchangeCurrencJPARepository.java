/**
 * 
 */
package com.amrit.microservices.currencyexchangeservice.orm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrit.microservices.currencyexchangeservice.bean.ExchangeCurrency;

/**
 * @author amrit
 *
 */
public interface ExchangeCurrencJPARepository extends JpaRepository<ExchangeCurrency,Long> {

	//Create interface methods with pattern "findBy<Search-column-1>And<Search-Column-2>"()

	public ExchangeCurrency findByFromAndTo(String from, String to);
}
