package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class ProfileEntity {

	@Id
	Long userId;

	@Column("username")
	String username;

	@Column("password")
	String password;

	//Default Constructor 
	public ProfileEntity() {
		
	}

	//Non-default constructor 
	public ProfileEntity(Long userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	//Non-default constructor
	public ProfileEntity(String username, String password) {
		super();
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

