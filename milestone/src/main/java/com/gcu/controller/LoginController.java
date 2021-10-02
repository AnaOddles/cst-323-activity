package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;
import com.gcu.model.UserList;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		System.out.println("Attempting login");
		//System.out.println(UserList.userList);
		
		// Check for validation errors 
		if (bindingResult.hasErrors()) {
			// Valid LoginModel fails -> doesn't pass all model property requirements
			// Set model attribute title
			model.addAttribute("title", "Login");
			return "login";
		}
		
		// Validation error check passed -> no validation errors
	
		//Check login attempt calling loginUser helper method
		// User Credentials are valid
		if(loginUser(loginModel)) {	
			// Set model attribute title
			model.addAttribute("title", "Login Success");
			model.addAttribute("userLoginMessage", "Hi " + loginModel.getUsername() + ", welcome back!");
			System.out.println("User logged in: " + loginModel.getUsername());
			return "loginSuccess";
		}
		
		// User Credentials are Invalid
		
		// Set model attribute title
		model.addAttribute("title", "Login Failure");
		model.addAttribute("userLoginMessage", "Uh oh... please try again " + loginModel.getUsername());
		System.out.println("Login failed for: " + loginModel.getUsername());
		return "loginFailure";
	}
	
	/*
	 * Helper method - checks global var of users for log in attempt 
	 *
	 * @param LoginModel
	 * 
	 * @return boolean
	 * 
	 */
	public boolean loginUser(LoginModel login){
		//Loop through hashamp of users
		for(LoginModel item : UserList.userList.values()) {
			//If login attempt matches the login of a registered user
			if(item.getUsername().equals(login.getUsername()) && 
					item.getPassword().equals(login.getPassword())) {
				return true;
			}
		}
		return false;	
	}

}
