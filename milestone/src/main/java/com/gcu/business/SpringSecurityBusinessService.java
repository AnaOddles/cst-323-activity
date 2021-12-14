// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.business;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.SecurityDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.LoggedInUser;
import com.gcu.model.LoginModel;
import com.gcu.util.DatabaseException;

import lombok.extern.slf4j.Slf4j;

// Service
@Service
@Slf4j
public class SpringSecurityBusinessService implements UserDetailsService {
	
	// Autowire service
	@Autowired
	private SecurityDataService service;


	/**
	 * Method to authenticate user in business layer
	 * 
	 * @param username (String) that captures username
	 * 
	 * @return UserDetails
	 * @throws UsernameNotFoundException 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Try to find the User in the database. If not found throw a User Not Found
		// exception else return a Spring Security User 
		LoggedInUser.user = new LoginModel();
		UserEntity user = null;
		try {
			//Use our security data service to see if we can authenticate logged in user
			user = service.findByCredentials(username);

		} catch (DatabaseException e) {
			//Catch database error and log
			log.error(e.getMessage());
		}
		//If user was returned from security data service - return user
		if (user != null) {

			// Required for games FK
			LoggedInUser.user.setUsername(username);
			LoggedInUser.user.setId(user.getUserId());
			
			log.info("Logged in with: " + username);
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		} else {
			//If user not found - throw exception
			throw new UsernameNotFoundException("username not found");
		}

	}

}
