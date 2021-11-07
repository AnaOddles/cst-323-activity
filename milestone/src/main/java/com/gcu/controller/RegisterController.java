// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// November 7, 2021
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
import com.gcu.business.UserBusinessServiceInterface;
import com.gcu.model.RegisterModel;
import com.gcu.util.DatabaseException;
import com.gcu.util.UserAlreadyExistsException;

/**
 * Login Controller class - all URI's related to Register page belong here
 * @author anasanchez
 *
 */
//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /register in URI - root
@Controller
@RequestMapping("/register")
public class RegisterController {
	//Inject security service using dependency injection
	@Autowired
	private UserBusinessServiceInterface userService;
	
	/**
	 * Return a view along with a model attribute Mappings - Invokes using '/' in
	 * URI after controller mapping '/register/'
	 * 
	 * @param model (Model) from register view
	 * 
	 * @return String as view forwarded to
	 * 
	 */
	@GetMapping("/")
	public String display(Model model) {
		// Set model attribute title
		model.addAttribute("title", "Register");
		// Set model attribute registerModel to instance of a new registerModel
		model.addAttribute("registerModel", new RegisterModel());
		// Return register view
		return "register";
	}

	/**
	 * Return a view name along with a model attribute Mappings - Invokes using
	 * '/doRegister' in URI after controller mapping '/register/doRegister'
	 * 
	 * @param registerModel (RegisterModel)
	 * @param bindingResult (BindingResult)
	 * @param model (Model)
	 * 
	 * @return String as view forwarded to
	 * @throws UserAlreadyExistsException 
	 * @throws DatabaseException 
	 * 
	 */
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) throws UserAlreadyExistsException, DatabaseException {

		// Check for validation errors
		if (bindingResult.hasErrors()) {
			// Valid RegisterModel fails -> doesn't pass all model property requirements
			// Set model attribute title
			model.addAttribute("title", "Register");
			// Return register view to show register page -> also outputs error messages
			return "register";
		}
		
		//Call service to register 
		try {
			userService.register(registerModel);
		}catch(UserAlreadyExistsException e){
			//If username used already exists - return back to register view
			model.addAttribute("title", "Register");
        	bindingResult.rejectValue("loginUser.username", "error.login", "username already taken");
			return "register";
		}

		
		// Set model attribute title
		model.addAttribute("title", "Register Success");
		// Set model attribute welcome with registerModel information
		model.addAttribute("welcome",
				"Welcome to the squad, " + registerModel.getFirstName() + " " + registerModel.getLastName());
		// Return RegisterSuccess view
		return "registerSuccess";
	}

}
