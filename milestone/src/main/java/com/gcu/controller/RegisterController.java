package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gcu.model.RegisterModel;
import com.gcu.model.UserList;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}

	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel registerModel, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Register");
			return "register";
		}
		
		int id = UserList.userList.size();
	
		
		registerModel.getLoginUser().setId(id);
		UserList.userList.put(id, registerModel);
		
		System.out.println("Id: " + registerModel.getLoginUser());
		System.out.println("UserModel Registered: " + registerModel.toString());
		model.addAttribute("title", "Register Success");
		model.addAttribute("welcome", "Welcome to the squad, " + registerModel.getFirstName() + " " + registerModel.getLastName());
		return "registerSuccess";
	}

}
