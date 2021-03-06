// Melanie Spence and Ana Sanchez
// CST-339
// Milestone
// December 13, 2021
// This is our own work

package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller class - all URI's related to home page belong here
 * @author anasanchez
 *
 */
//Annotations to make the class a controller
//Requested Mapping to set the path to invoke controller - invoke using / in URI - root
@Controller
@RequestMapping("/")
public class HomeController {

	/**
	 * Return a view name along with a model attribute Mapping - Invokes using '/'
	 * or '' in URI - root
	 * 
	 * @param model (Model)
	 * 
	 * @return String for view
	 * 
	 */
	@GetMapping("/")
	public String goHome(Model model) {
		// Add model attribute Title
		model.addAttribute("title", "Home");
		return "home";
	}
}
