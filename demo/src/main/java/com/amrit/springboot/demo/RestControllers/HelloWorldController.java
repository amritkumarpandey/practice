/**
 * 
 */
package com.amrit.springboot.demo.RestControllers;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestController;

import com.amrit.springboot.demo.beans.GreetingBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author amrit
 *
 */
@RestController
public class HelloWorldController {

	/**
	 * 
	 */
	
	public HelloWorldController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/greet")
	public String greet() {
		return "Hello, How are you doing today. Wish you an awesome day ahead.";
	}
	
	/*@RequestMapping(method = RequestMethod.GET , path = "/greet/path-variable/{name}")
	public GreetingBean greetWithMessage(@PathVariable String name) {
		return new GreetingBean(name);
	}
	
	@GetMapping("/greet/{name}")
	public GreetingBean greetThePerson(@PathVariable String name) {
		return new GreetingBean(name);
	}*/
	
	

}
