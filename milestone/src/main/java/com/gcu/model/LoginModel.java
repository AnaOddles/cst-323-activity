// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Object Model to capture user credentials
 * @author anasanchez
 *
 */
public class LoginModel {
	
	// Properties
	// @ Signals data validation rules
	
	/**
	 * Id of user
	 */
	private long id;

	/**
	 * Username of user (String)
	 */
	@NotBlank(message = "Username cannot be blank")
	@NotNull(message = "Username is a required field")
	@Size(max = 20, message = "Username must be less than 20 characters")
	private String username;

	/**
	 * Password of user (String)
	 */
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password is a required field")
	@Size(max = 30, message = "Password must be less than 30 characters")
	private String password;
	
	// GETTERS AND SETTERS
	/**
	 * Access to user's ID
	 * @return ID (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * Access to set user's ID
	 * @param id (long) 
	 * 
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Access to user's username
	 * @return username (string)
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Access to set user's username
	 * @param username (string)
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Access to user's password 
	 * @return password (string)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Access to set user's password 
	 * @param password (string)
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return string interpretation of LoginModel (string)
	 */
	@Override
	public String toString() {
		return "LoginModel:\n id: " + id + ",\n username: " + username + ",\n password: " + password;
	}
	
	

}
