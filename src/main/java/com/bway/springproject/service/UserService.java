package com.bway.springproject.service;

import com.bway.springproject.model.User;

public interface UserService {
	
	
	void userSignup(User user);
	User userLogin(String un, String psw);
	User isUserExist(String username); //created a method to check if the user exists
}
