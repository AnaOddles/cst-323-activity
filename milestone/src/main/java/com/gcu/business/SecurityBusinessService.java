package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;
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
	 * Method to register user 
	 * 
	 * @param register (RegisterMode) that captures user registration attributes
	 * 
	 */
	@Override
	public void register(RegisterModel register) {
		// Retrieve ID by looking at the size of the HashMap
		int id = UserList.userList.size();

		// Set the models id by getting the login user object and setting the id
		register.getLoginUser().setId(id);
		// Add the LoginModel to the HashMap using the ID as the key and the LoginModel
		// as the value
		UserList.userList.put(id, register.getLoginUser());

		// Print the ID and UserModel to the console
		System.out.println("Id: " + register.getLoginUser());
		System.out.println("UserModel Registered: " + register.toString());
	}

	/**
	 * Method to login in user 
	 * 
	 * @param login LoginModel that captures user login credentials
	 * @return boolean if user successfully logins in, false otherwise
	 */
	@Override
	public boolean login(LoginModel login) {
		
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
	 */
	@Override
	public void init() {
		System.out.println("In the SecurityBusinessService.init()");
		
	}

	/**
	 * Method for spring bean upon destroy
	 * 
	 */
	@Override
	public void destroy() {
		System.out.println("In the SecurityBusinessService.destroy()");
		
	}

}