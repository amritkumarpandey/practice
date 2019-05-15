/**
 * 
 */
package com.amrit.springboot.demo.demo.services.users;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;
/**
 * @author amrit
 *
 */
public class User {
	@NotBlank
	@Positive
	private long id;
	
	@Size(min=2, message ="Minimum length should be 2 characters")
	private String username;
	private Date creationDate;

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(long id , String username , Date userSince) {
		this.id = id;
		this.username = username;
		this.creationDate = userSince;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ID: %s , Username: %s , User Since: %s .",this.id,this.username, this.creationDate.toString());
	}

}
