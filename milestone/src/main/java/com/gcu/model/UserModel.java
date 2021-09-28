package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

	private long id;
	
	@NotEmpty(message = "First Name cannot be empty")
	@NotBlank(message = "First Name cannot be blank")
	@NotNull(message = "First Name is a required field")
	@Size(min = 1, max = 20, message = "First Name must be between 1 and 20 characters")
	private String firstName;
	
	@NotEmpty(message = "Last Name cannot be empty")
	@NotBlank(message = "Last Name cannot be blank")
	@NotNull(message = "Last Name is a required field")
	@Size(min = 1, max = 20, message = "Last Name must be between 1 and 20 characters")
	private String lastName;

	@Min(value = 5, message = "Age cannot be less than 5")
	@Max(value = 150, message = "Age cannot be greater than 150")
	private int age;
	
	@NotEmpty(message = "Email cannot be empty")
	@NotBlank(message = "Email cannot be blank")
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotEmpty(message = "Username cannot be empty")
	@NotBlank(message = "Username cannot be blank")
	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 20, message = "Username must be between 1 and 20 characters")
	private String username;
	
	@NotEmpty(message = "Password cannot be empty")
	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 30, message = "Password must be between 1 and 30 characters")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}