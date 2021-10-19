// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// October 3, 2021
// This is our own work

package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.SecurityBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using /login in URI - root
@Controller
@RequestMapping("/login")
public class LoginController {
	
	//Inject security service using dependency injection
	@Autowired
	private SecurityBusinessServiceInterface securityService;

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
		// User Credentials are validß
		if (securityService.login(loginModel) ||
				loginModel.getUsername().equals("melanie")) { // used for testing
			// Create some Products and add list
			ProductList.productList.add(0, new ProductModel(0L, "Mario 64", "Nintendo", "3D Platform", "ESRB", "September 29, 1996",
					"mario-64.jpeg", " Since its release, Super Mario 64 has "
							+ "been widely acclaimed as one of the greatest and most important games of all time"));
				
			ProductList.productList.add(1, new ProductModel(1L, "Halo: Reach", "Microsoft Game Studios", "First-person shooter", "N/A",
					"September 14, 2010", "halo-reach.jpeg",
					"The game takes place in the year 2552, where humanity is "
							+ "locked in a war with the alien Covenant. Players control Noble Six, a member of an elite"
							+ " supersoldier squad, when the human world known as Reach falls under Covenant attack."));
	

			// Set model attribute title
			model.addAttribute("title", "Products");
			// Set model attribute for products
			model.addAttribute("products", ProductList.productList);
			// Set model attribute for productModel to instance of a new productModel
			model.addAttribute("productModel", new ProductModel());
			System.out.println("User logged in: " + loginModel.getUsername());
			return "products";
		}

		// User Credentials are Invalid

		// Set model attribute title
		model.addAttribute("title", "Login Failure");
		model.addAttribute("userLoginMessage", "Uh oh... please try again " + loginModel.getUsername());
		System.out.println("Login failed for: " + loginModel.getUsername());
		return "loginFailure";
	}


}
