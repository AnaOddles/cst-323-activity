package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel extends LoginModel {

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

	@Override
	public String toString() {
		return "RegisterModel:\n id: " + super.getId() + ",\n firstName: " + firstName + ",\n lastName: " + lastName
				+ ",\n age: " + age + ",\n email: " + email + ",\n username: " + super.getUsername()
				+ ",\n password: " + super.getPassword();
	}

}
