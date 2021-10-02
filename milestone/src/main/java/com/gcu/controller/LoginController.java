// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.LoginModel;

//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /login in URI - root
@Controller
@RequestMapping("/login")
public class LoginController {

	/*
	 * Return a view name along with a model attribute Mappings - Invokes using '/'
	 * in URI after controller mapping '/login/'
	 * 
	 * @param Model
	 * 
	 * @return String
	 * 
	 */
	@GetMapping("/")
	public String login(Model model) {
		// Set model attribute title
		model.addAttribute("title", "Login");
		// Set model attribute loginModel to instance of a new LoginModel
		model.addAttribute("loginModel", new LoginModel());
		// Return login view
		return "login";
	}

	/*
	 * Return a view name along with a model attribute Mappings - Invokes using
	 * '/doLogin' in URI after controller mapping '/login/doLogin'
	 * 
	 * @param (valid) LoginModel, BindingResult, Model
	 * 
	 * @return String
	 * 
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

		// Check for validation errors
		if (bindingResult.hasErrors()) {
			// Valid LoginModel fails -> doesn't pass all model property requirements
			// Set model attribute title
			model.addAttribute("title", "Login");
			// Return login view to show login page -> also outputs error messages
			return "login";
		}

		// Validation error check passed -> no validation errors

		// Set model attribute title
		model.addAttribute("title", "Login Success");

		// TODO Add Logic to check HashMap to see if user has entered valid credentials

		// User Credentials are Invalid
		// TODO Create loginFailure
		// return "loginFailure";

		// User Credentials are valid
		// Return LoginSuccess view
		return "loginSuccess";
	}

}
