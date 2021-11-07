// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.SecurityDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.LoggedInUser;
import com.gcu.model.LoginModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.InvalidCredentialsException;
import com.gcu.util.UserAlreadyExistsException;
/**
 * Business Service used for user security and authentication
 * @author anasanchez
 *
 */
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
			
		//Call Service to authenticate user - returns User Entity from databawe
		UserEntity user = service.findByCredentials(new UserEntity(login.getUsername(), login.getPassword()));
		
		//If User is returned - log in user - else - throw invalid credentials exception
		if(user != null)
		{
			// Set ID of logged in user
			login.setId(user.getUserId()); // Required for games FK
			LoggedInUser.user = login;
			
			System.out.println("Logged in with: " + login.getUsername());
			return true;
		}
		else
		{
			System.out.println("Login failed with: " + login.getUsername());
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