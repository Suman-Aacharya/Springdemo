package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/login","/"})
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model) {
		
		
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = userService.userLogin(user.getUsername(),user.getPassword());
		
		
		
		if(u != null) {
			model.addAttribute("uname",u.getFname());
			return "Home";
		}
		
		model.addAttribute("error", "User not found !!");
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignup() {
		
		
	return "SignupForm";
	
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model) {
		
		User u = userService.isUserExist(user.getUsername());
		
		if(u != null) { // == bhaneko chaina bhane
			model.addAttribute("message","user already exists !!");
			return "SignupForm";	
		
		}
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.userSignup(user);
		
		return "LoginForm";
	}

		@GetMapping("/logout")
		public String logout() {
			
			return "LoginForm";
		}
}
