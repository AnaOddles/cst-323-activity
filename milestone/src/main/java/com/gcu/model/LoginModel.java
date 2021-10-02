// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// LoginModel class
public class LoginModel {
	
	// Properties
	// @ Signals data validation rules
	
	private long id;

	@NotBlank(message = "Username cannot be blank")
	@NotNull(message = "Username is a required field")
	@Size(max = 20, message = "Username must be less than 20 characters")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password is a required field")
	@Size(max = 30, message = "Password must be less than 30 characters")
	private String password;
	
	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "LoginModel:\n id: " + id + ",\n username: " + username + ",\n password: " + password;
	}
	
	

}
