package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("title", "Login");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(Model model) {
		model.addAttribute("title", "Login Success");
		return "loginSuccess";
	}
	
}
