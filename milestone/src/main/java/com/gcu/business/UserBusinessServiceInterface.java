// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
// This is our own work

package com.gcu.business;
import com.gcu.model.RegisterModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.UserAlreadyExistsException;

/**
 * Interface that specifies functionality for user and user profile
 * @author anasanchez
 *
 */
//Using @Service to create concrete instance of security service as a spring bean
public interface UserBusinessServiceInterface {

	/**
	 * Functionality for registering and adding a user to application
	 * 
	 * @param registerUser (RegisterMode) that captures user registration attributes
	 * 
	 * @return boolean
	 * @throws UserAlreadyExistsException 
	 * @throws DatabaseException 
	 * 
	 */
	boolean register(RegisterModel registerUser) throws UserAlreadyExistsException, DatabaseException;
	
	/**
	 * Method for spring bean upon init
	 * 
	 * @return void
	 */
	void init();
	/**
	 * Method for spring bean upon destroy
	 * 
	 * @return void
	 */
	void destroy();
}
