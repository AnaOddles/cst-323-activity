// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Profile Entity to capture user profile information
 * 
 * @author melzs
 *
 */
// Table for profiles
@Table("profiles")
public class ProfileEntity {

	/**
	 * Profile ID (long)
	 */
	@Id
	Long profileId;

	/**
	 * User ID (long)
	 */
	@Column("user_Id")
	Long userId;

	/**
	 * First name of user (String)
	 */
	@Column("firstname")
	String firstname;
	/**
	 * Last name of user (String)
	 */
	@Column("lastname")
	String lastname;

	/**
	 * Age of user (int)
	 */
	@Column("age")
	int age;

	/**
	 * Email of user (String)
	 */
	@Column("email")
	String email;

	// Default Constructor
	public ProfileEntity() {

	}

	// Non-default constructor
	/**
	 * Non default constructor with PK
	 * 
	 * @param profileId
	 * @param userId
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param email
	 */
	public ProfileEntity(Long profileId, Long userId, String firstname, String lastname, int age, String email) {
		this.profileId = profileId;
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}

	// Non-default constructor
	/**
	 * Non default constructor no PK
	 * 
	 * @param userId
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param email
	 */
	public ProfileEntity(Long userId, String firstname, String lastname, int age, String email) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}

	/**
	 * Non Default Construct no Ids
	 * 
	 * @param firstname
	 * @param lastname
	 * @param age
	 * @param email
	 */
	public ProfileEntity(String firstname, String lastname, int age, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}

	// Getter and Setters
	/**
	 * Access to user's first name
	 * 
	 * @return first name (String)
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Access to Profile id
	 * 
	 * @return profile id (long)
	 */
	public Long getProfileId() {
		return profileId;
	}

	/**
	 * Set profile Id
	 * 
	 * @param profileId (long)
	 */
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	/**
	 * Access to profile's user id
	 * 
	 * @return userid (long)
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Access to set user's id
	 * 
	 * @param userId (long)
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Access to set user's first name
	 * 
	 * @param firstName (String)
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Access to user's last name
	 * 
	 * @return lastname (String)
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Access to set user's last name
	 * 
	 * @param lastName (String)
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * Override method for string interpretation of Profile Entity
	 * 
	 * @return toString (String)
	 */
	@Override
	public String toString() {
		return "ProfileEntity [profileId=" + profileId + ", userId=" + userId + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", age=" + age + ", email=" + email + "]";
	}

}
