package com.gcu.business;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

/**
 * Interface for Security Business Service
 * @author anasanchez
 *
 */
public interface SecurityBusinessServiceInterface {
	//Methods 
	
	/**
	 * Method to register user 
	 * 
	 * @param registerUser (RegisterMode) that captures user registration attributes
	 * 
	 */
	void register(RegisterModel registerUser);
	
	/**
	 * Method to login in user 
	 * 
	 * @param loginModel (LoginModel) that captures user login credentials
	 * 
	 * @return boolean if user successfully logins in, false otherwise
	 */
	boolean login(LoginModel loginModel);
	
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
