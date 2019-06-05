package com.yuanzhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuanzhi.pojo.User;
import com.yuanzhi.serivce.UserService;

@Controller
public class UserController {

	@Autowired
	UserService UserService;
	
	@RequestMapping("/getUsers")
	public User getUsers(String username) {
		
		
		return UserService.findByName(username);
	}
	
}
