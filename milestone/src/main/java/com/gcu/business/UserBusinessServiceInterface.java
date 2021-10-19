// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;
import com.gcu.model.RegisterModel;

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
	 */
	void register(RegisterModel registerUser);
}
