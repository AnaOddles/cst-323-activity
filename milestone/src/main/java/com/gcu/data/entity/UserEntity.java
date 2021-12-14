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
 * User Entity to capture user credentials
 * 
 * @author melzs
 *
 */
// Table for users
@Table("users")
public class UserEntity {
	/**
	 * Access to set user's email
	 * 
	 * @param email (String)
	 */
	@Id
	Long userId;
	/**
	 * Username of user (String)
	 */
	@Column("username")
	String username;
	/**
	 * Password of user (String)
	 */
	@Column("password")
	String password;

	// Default Constructor
	/**
	 * Default Constructor
	 */
	public UserEntity() {

	}

	// Non-default constructor
	/**
	 * Non Default Constructor
	 * 
	 * @param userId
	 * @param username
	 * @param password
	 */
	public UserEntity(Long userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	/**
	 * Non default constructor no PK
	 * 
	 * @param username
	 * @param password
	 */
	// Non-default constructor
	public UserEntity(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// GETTERS AND SETTERS

	/**
	 * Access to user's ID
	 * 
	 * @return ID (long)
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Access to set user's ID
	 * 
	 * @param id (long)
	 * 
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * To String
	 * 
	 * @return string interpretation of LoginEntity (string)
	 */
	@Override
	public String toString() {
		return "UserEntity:\n userId: " + userId + ",\n username: " + username + ",\n password: " + password;
	}

}
