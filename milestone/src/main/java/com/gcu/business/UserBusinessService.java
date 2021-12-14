// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.UsersDataService;
import com.gcu.data.entity.ProfileEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegisterModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.UserAlreadyExistsException;

import lombok.extern.slf4j.Slf4j;
/**
 * Business Service used for user and user profile functionality
 * @author anasanchez
 *
 */
// Service
@Slf4j
@Service
public class UserBusinessService implements UserBusinessServiceInterface {
	
	// Autowire service
	@Autowired
	UsersDataService service;
	
	/**
	 * Method to register user 
	 * 
	 * @param register (RegisterMode) that captures user registration attributes
	 * 
	 * @return boolean
	 * @throws DatabaseException 
	 */
	@Override
	public boolean register(RegisterModel register) throws UserAlreadyExistsException, DatabaseException {
		log.debug("In User Business Service - register");
		
		log.info("Registering a user to the database - " + register.getLoginUser().getUsername());
		
		//Call service to register user 
		int registeredUser = service.create(new UserEntity(register.getLoginUser().getUsername(), register.getLoginUser().getPassword())
				,new ProfileEntity(register.getFirstName(), register.getLastName(), register.getAge(),
							register.getEmail()));
	
		//If user already exists throw exception
		if(registeredUser == 1) {
			log.error("User already exists - " + register.getLoginUser().getUsername());
			throw new UserAlreadyExistsException();
		}
		return true;
	}
	
	/**
	 * Method for spring bean upon init
	 * 
	 * @return void
	 */
	@Override
	public void init() {
		System.out.println("In the UserBusinessService.init()");
		
	}

	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	@Override
	public void destroy() {
		System.out.println("In the UserBusinessService.destroy()");
		
	}

}
