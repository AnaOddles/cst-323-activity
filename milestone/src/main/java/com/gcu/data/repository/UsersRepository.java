// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long> {
	/**
	 * Return User Entity by Username and Password Credentials
	 * @param username
	 * @param password
	 * @return User Entity
	 */
	UserEntity findByUsernameAndPassword(String username, String password);
	/**
	 * Return User Entity by Username Credential
	 * @param username
	 * @return User Entity
	 */
	UserEntity findByUsername(String username);
}

