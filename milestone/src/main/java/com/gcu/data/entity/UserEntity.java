package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class UserEntity {

	@Id
	Long userId;

	@Column("username")
	String username;

	@Column("password")
	String password;

	//Default Constructor 
	public UserEntity() {
		
	}

	//Non-default constructor 
	public UserEntity(Long userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	//Non-default constructor
	public UserEntity(String username, String password) {
		this.username = username;
		this.password = password;
	}

	//Getter and Setters
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
		return "LoginEntity [userId=" + userId + ", username=" + username + ", password=" + password + "]";
	}

}

