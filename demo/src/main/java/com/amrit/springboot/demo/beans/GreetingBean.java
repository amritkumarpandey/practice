/**
 * 
 */
package com.amrit.springboot.demo.beans;

/**
 * @author amrit
 *
 */
public class GreetingBean {
	private String message;


	/**
	 * 
	 */
	public GreetingBean(String inputMessage) {
		this.message = inputMessage;
	}
	
	public void setMessage(String inputMessage) {
		this.message = inputMessage;
	}
	
	public String getMessage() {
		return this.toString();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello " + message + "! Hope you are doing awesome today!!";
	}
}
