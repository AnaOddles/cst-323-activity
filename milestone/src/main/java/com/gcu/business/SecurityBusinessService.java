// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;
import com.gcu.model.UserList;
/**
 * Business Service used for user security and authentication
 * @author anasanchez
 *
 */
//Using @Service to create concrete instance of security service as a spring bean
@Service
public class SecurityBusinessService implements SecurityBusinessServiceInterface {

	/**
	 * Method to login in user 
	 * 
	 * @param login LoginModel that captures user login credentials
	 * @return boolean if user successfully logins in, false otherwise
	 */
	@Override
	public boolean authenticateUser(LoginModel login) {
		
		// Loop through hashamp of users
		for (LoginModel item : UserList.userList.values()) {
			// If login attempt matches the login of a registered user
			if (item.getUsername().equals(login.getUsername()) && item.getPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;
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