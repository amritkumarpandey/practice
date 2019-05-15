/**
 * 
 */
package com.amrit.springboot.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author amrit
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApplicationUserNotFoundException extends RuntimeException {

	public ApplicationUserNotFoundException(String message) {
		super(message);
	}

}
