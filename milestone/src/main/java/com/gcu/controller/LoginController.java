package com.gcu.controller;


/**
 * Login Controller class - all URI's related to login page belong here
 * @author anasanchez
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LoginController {
	
	//Method controller that displays login home 
	@GetMapping("/login")
	public String display(Model model)
	{
		//Display Login Form View 
		model.addAttribute("title", "Login Form");
		return "login";
	}
}
