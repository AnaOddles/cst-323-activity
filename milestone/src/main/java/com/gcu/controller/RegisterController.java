package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register");
		return "register";
	}

	@PostMapping("/doRegister")
	public String doRegister(Model model) {
		model.addAttribute("title", "Register Success");
		return "registerSuccess";
	}

}
