// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.model;

import java.util.HashMap;

/**
 * Object Model used to capture list of users logged in
 * @author anasanchez
 *
 */
public class UserList {
	/**
	 * Global Variable -> HashMap with UserList with Integer (ID) and LoginModel (VALUE) 
	 */
	public static HashMap<Integer, LoginModel> userList = new HashMap<Integer, LoginModel>();
}
