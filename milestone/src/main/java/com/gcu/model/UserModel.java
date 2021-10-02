package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserModel {
	// Properties
	// @ Signals data validation rules

	private long id;

	@NotBlank(message = "First Name cannot be blank")
	@NotNull()
	@Size(max = 20, message = "First Name must be less than 20 characters")
	private String firstName;

	@NotBlank(message = "Last Name cannot be blank")
	@NotNull()
	@Size(max = 20, message = "Last Name must be less than 20 characters")
	private String lastName;

	@Min(value = 5, message = "Age cannot be less than 5")
	@Max(value = 150, message = "Age cannot be greater than 150")
	private int age;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Please enter a valid email address")
	private String email;

	@NotBlank(message = "Phone Number cannot be blank")
	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Phone number must be in 111-111-1111 format")
	private String phoneNum;

	@NotBlank(message = "Username cannot be blank")
	@NotNull(message = "Username is a required field")
	@Size(max = 20, message = "Username must be less than 20 characters")
	private String username;

	@NotBlank(message = "Password cannot be blank")
	@NotNull(message = "Password is a required field")
	@Size(max = 30, message = "Password must be less than 30 characters")
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

	@Override
	public String toString() {
		return "UserModel:\n id: " + id + ",\n firstName: " + firstName + ",\n lastName: " + lastName + ",\n age: "
				+ age + ",\n email: " + email + ",\n phoneNum: " + phoneNum + ",\n username: " + username
				+ ",\n password: " + password;
	}

}
