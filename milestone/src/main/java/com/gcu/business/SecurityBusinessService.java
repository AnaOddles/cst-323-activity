// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.Milestone;
import com.gcu.data.SecurityDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.LoggedInUser;
import com.gcu.model.LoginModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.InvalidCredentialsException;
import com.gcu.util.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;
/**
 * Business Service used for user security and authentication
 * @author anasanchez
 *
 */
@Slf4j
//Using @Service to create concrete instance of security service as a spring bean
@Service
public class SecurityBusinessService implements SecurityBusinessServiceInterface {
	
	@Autowired
	SecurityDataService service;
	/**
	 * Method to login in user 
	 * 
	 * @param login LoginModel that captures user login credentials
	 * @return boolean if user successfully logins in, false otherwise
	 * @throws InvalidCredentialsException 
	 * @throws DatabaseException 
	 * @throws UserAlreadyExistsException 
	 */
	@Override
	public boolean authenticateUser(LoginModel login) throws InvalidCredentialsException, DatabaseException {
		log.debug("In Security Business Service - authenticateUser");
			
		//Call Service to authenticate user - returns User Entity from database
		UserEntity user = service.findByCredentials(new UserEntity(login.getUsername(), login.getPassword()));
		
		//If User is returned - log in user - else - throw invalid credentials exception
		if(user != null)
		{
			// Set ID of logged in user
			login.setId(user.getUserId()); // Required for games FK
			LoggedInUser.user = login;
			
			log.info("Logged in with: " + login.getUsername());
			return true;
		}
		//If user is not returned - throw invalid credentials exceotion
		else
		{
			log.info("Login failed with: " + login.getUsername());
			throw new InvalidCredentialsException();
		}
		
	}
	
	/**
	 * Method for spring bean upon init
	 * 
	 * @return void
	 */
	@Override
	public void init() {
		System.out.println("In the SecurityBusinessService.init()");
		
	}

	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	@Override
	public void destroy() {
		System.out.println("In the SecurityBusinessService.destroy()");
		
	}

}