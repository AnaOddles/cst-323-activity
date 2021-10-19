package com.gcu.business;
import com.gcu.model.LoginModel;


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
	 */
	boolean authenticateUser(LoginModel loginModel);
	
	/**
	 * Method for spring bean upon init
	 * 
	 */
	void init();
	
	/**
	 * Method for spring bean upon destroy
	 * 
	 */
	void destroy();
}
