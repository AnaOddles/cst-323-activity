// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 24, 2021
// This is our own work

package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityBusinessServiceInterface;
import com.gcu.model.LoggedInUser;
import com.gcu.model.LoginModel;

/**
 * Login Controller class - all URI's related to login page belong here
 * @author anasanchez
 *
 */
//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /login in URI - root
@Controller
@RequestMapping("/login")
public class LoginController {

	// Inject security service using dependency injection
	@Autowired
	private SecurityBusinessServiceInterface securityService;

	/**
	 * Return a view name along with a model attribute Mappings - Invokes using '/'
	 * in URI after controller mapping '/login/'
	 * 
	 * @param model (Model) from login view 
	 * 
	 * @return String for view forwarded to
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

	/**
	 * Return a view name along with a model attribute Mappings - Invokes using
	 * '/doLogin' in URI after controller mapping '/login/doLogin'
	 * 
	 * @param loginModel (LoginModel)
	 * @param bindingResult (BindingResult), 
	 * @param model (Model)
	 * 
	 * @return String
	 * 
	 */
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		System.out.println("Attempting login");

		// Check for validation errors
		if (bindingResult.hasErrors()) {
			// Valid LoginModel fails -> doesn't pass all model property requirements
			// Set model attribute title
			model.addAttribute("title", "Login");
			// Return login view to show login page -> also outputs error messages
			return "login";
		}

		// Validation error check passed -> no validation errors

		// Check login attempt calling loginUser helper method
		
		// User Credentials are valid
		if (securityService.authenticateUser(loginModel))
		{	
			// Set model attribute title
			model.addAttribute("title", "Login Success");
			// Set model attribute userLoginMessage
			model.addAttribute("userLoginMessage", "You have successfully logged in, " + loginModel.getUsername() + "!");
			// Set ID of logged in user
			LoggedInUser.user = loginModel;
			System.out.println("Logged In User ID: " + LoggedInUser.user);
			model.addAttribute("user", LoggedInUser.user);
			System.out.println("User logged in: " + loginModel.getUsername());
			return "loginSuccess";
		}

		// User Credentials are Invalid

		// Set model attribute title
		model.addAttribute("title", "Login Failure");
		// Set model attribute userLoginmessage
		model.addAttribute("userLoginMessage", "Uh oh... please try again " + loginModel.getUsername());
		System.out.println("Login failed for: " + loginModel.getUsername());
		return "loginFailure";
	}

}
