/**
 * 
 */
package com.amrit.springboot.demo.exceptions;

import java.util.Date;

/**
 * @author amrit
 *
 */
public class ExceptionResponse {
	private Date date;
	private String exceptionMessage;
	private String details;

	/**
	 * 
	 */
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param date
	 * @param exceptionMessage
	 * @param details
	 */
	public ExceptionResponse(Date date, String exceptionMessage, String details) {
		super();
		this.date = date;
		this.exceptionMessage = exceptionMessage;
		this.details = details;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param exceptionMessage the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
