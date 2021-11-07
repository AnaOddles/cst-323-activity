// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Object Model to capture user registration
 * @author anasanchez
 *
 */
public class RegisterModel {

	// Properties
	// @ Signals data validation rules

	/**
	 * First name of user (String)
	 */
	@NotBlank(message = "First Name cannot be blank")
	@NotNull()
	@Size(max = 20, message = "First Name must be less than 20 characters")
	private String firstName;

	/**
	 * Last name of user (String)
	 */
	@NotBlank(message = "Last Name cannot be blank")
	@NotNull()
	@Size(max = 20, message = "Last Name must be less than 20 characters")
	private String lastName;

	/**
	 * Age of user (int)
	 */
	@Min(value = 5, message = "Age cannot be less than 5")
	@Max(value = 150, message = "Age cannot be greater than 150")
	private int age;

	/**
	 * Email of user (String)
	 */
	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Please enter a valid email address")
	private String email;

	/**
	 * Phone number of user (String)
	 */
	@NotBlank(message = "Phone Number cannot be blank")
	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message="Phone number must be in 111-111-1111 format")
	private String phoneNum;

	/**
	 * Object Model for to capture user credentials. Establishes a HAS-A relationship with LoginModel
	 */
	// VALID checks HAS-A LoginModel data validation
	@Valid
	private LoginModel loginUser;

	// GETTERS AND SETTERS
	/**
	 * Access to user's first name 
	 * @return first name (String)
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Access to set user's first name
	 * @param firstName (String)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Access to user's last name
	 * @return lastname (String) 
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Access to set user's last name 
	 * @param lastName (String)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Access to user's age 
	 * @return age (int)
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Access to set user's age 
	 * @param age (int)
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Access to user's email 
	 * @return email (String)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Access to set user's email 
	 * @param email (String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Access to user's login credentials 
	 * @return loginUser (LoginModel)
	 */
	public LoginModel getLoginUser() {
		return loginUser;
	}

	/**
	 * Access to set user's login credentials 
	 * @param loginUser (LoginModel)
	 */
	public void setLoginUser(LoginModel loginUser) {
		this.loginUser = loginUser;
	}

	/**
	 * Access to user's phone number 
	 * @return phoneNum (String)
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Access to set user's phone number
	 * @param phoneNum (String)
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * Override method for string interpretation of RegisterModel
	 * @return toString (String)
	 */
	@Override
	public String toString() {
		return "RegisterModel:\n id: " + loginUser.getId() + ",\n firstName: " + firstName + ",\n lastName: " + lastName
				+ ",\n age: " + age + ",\n email: " + email + ",\nphone number: " + phoneNum + ",\n username: "
				+ loginUser.getUsername() + ",\n password: " + loginUser.getPassword();
	}

}
