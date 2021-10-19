// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.business;

import org.springframework.stereotype.Service;

import com.gcu.model.RegisterModel;
import com.gcu.model.UserList;
/**
 * Business Service used for user and user profile functionality
 * @author anasanchez
 *
 */
@Service
public class UserBusniessService implements UserBusinessServiceInterface {

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

}
