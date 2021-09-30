package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.model.UserList;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("userModel", new UserModel());
		return "register";
	}

	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model) {
		
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register");
			return "register";
		}
		
		int id = UserList.userList.size();
		userModel.setId(id);
		UserList.userList.put(id, userModel);
		
		System.out.println("Id: " + userModel.getId());
		System.out.println("UserModel Registered: " + userModel.toString());
		model.addAttribute("title", "Register Success");
		model.addAttribute("welcome", "Welcome to the squad, " + userModel.getFirstName() + " " + userModel.getLastName());
		return "registerSuccess";
	}

}
