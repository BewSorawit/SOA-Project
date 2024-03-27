package com.example.project.controller;

import com.example.project.model.Users;
import com.example.project.service.UsersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService u;
	
	@PostMapping("/auth")
	public Users login(@RequestBody Users user) {
		Users u2 = u.login(user.getUserName(), user.getPassword());
		return u2;
	}
	
	@GetMapping("/test")
	public List<Users> test() {
		return u.getAllUsers();
	}
	 
}
