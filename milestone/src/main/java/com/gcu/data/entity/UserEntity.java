package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("profiles")
public class UserEntity {

	@Id
	Long profileId;

	@Column("userId")
	Long userId;

	@Column("firstname")
	String firstname;
	
	@Column("lastname")
	String lastname;
	
	@Column("age")
	int age; 
	
	@Column("email")
	String email;

	//Default Constructor 
	public UserEntity() {
		
	}

	//Non-default constructor
	public UserEntity(Long profileId, Long userId, String firstname, String lastname, int age, String email) {
		this.profileId = profileId;
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}
	
	//Non-default constructor 
	public UserEntity(Long userId, String firstname, String lastname, int age, String email) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}
	
	//Getter and Setters
	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		return "UserEntity [profileId=" + profileId + ", userId=" + userId + ", firstname=" + firstname + ", lastname="
				+ lastname + ", age=" + age + ", email=" + email + "]";
	}
	
}

