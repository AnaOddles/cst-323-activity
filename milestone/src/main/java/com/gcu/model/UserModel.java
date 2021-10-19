// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author melzs
 *
 */
public class UserModel {
	// Properties
	// @ Signals data validation rules

	/**
	 * Id of user
	 */
	private long id;

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
	 * Age of user (String)
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
	@Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{4}", message = "Phone number must be in 111-111-1111 format")
	private String phoneNum;

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
	 * 
	 * @return ID (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * Access to set user's ID
	 * 
	 * @param id (long)
	 * 
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Access to user's first name
	 * 
	 * @return first name (String)
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Access to set user's first name
	 * 
	 * @param firstName (String)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Access to user's last name
	 * 
	 * @return lastname (String)
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Access to set user's last name
	 * 
	 * @param lastName (String)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Access to user's age
	 * 
	 * @return age (int)
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Access to set user's age
	 * 
	 * @param age (int)
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Access to user's email
	 * 
	 * @return email (String)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Access to set user's email
	 * 
	 * @param email (String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Access to user's phone number
	 * 
	 * @return phoneNum (String)
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * Access to set user's phone number
	 * 
	 * @param phoneNum (String)
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * Access to user's username
	 * 
	 * @return username (string)
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Access to set user's username
	 * 
	 * @param username (string)
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Access to user's password
	 * 
	 * @return password (string)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Access to set user's password
	 * 
	 * @param password (string)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return string interpretation of UserModel (string)
	 */
	@Override
	public String toString() {
		return "UserModel:\n id: " + id + ",\n firstName: " + firstName + ",\n lastName: " + lastName + ",\n age: "
				+ age + ",\n email: " + email + ",\n phoneNum: " + phoneNum + ",\n username: " + username
				+ ",\n password: " + password;
	}

}
