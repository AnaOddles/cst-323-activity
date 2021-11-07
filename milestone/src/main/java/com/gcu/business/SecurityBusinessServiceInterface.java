// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;
import com.gcu.model.LoginModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.InvalidCredentialsException;


/**
 * Interface that specifies functionality for user authentication and security
 * @author anasanchez
 *
 */
public interface SecurityBusinessServiceInterface {
	//Methods
	
	/**
	 * Method to login in user 
	 * 
	 * @param loginModel (LoginModel) that captures user login credentials
	 * 
	 * @return boolean if user successfully logins in, false otherwise
	 * @throws InvalidCredentialsException 
	 * @throws DatabaseException 
	 */
	boolean authenticateUser(LoginModel loginModel) throws InvalidCredentialsException, DatabaseException;
	
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
