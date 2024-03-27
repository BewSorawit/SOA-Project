package com.example.project.controller;

import com.example.project.model.Users;
import com.example.project.service.UsersService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService u;
	
	@PostMapping("/auth")
	public Users login(@RequestBody Users user,HttpSession session) {
		Users u2 = u.login(user);
		
		session.setAttribute("USER_OBJ", u2);
		
		return u2;
	}
	
	@PostMapping("/authCheck")
	public Users login2(@RequestBody Users user,HttpSession session) {
		
		Users uss = (Users) session.getAttribute("USER_OBJ");
		Users u2 = u.login(user);
		
		
		if(uss == null) {
			System.out.println("FALSE");
		}else if(uss.getId()==u2.getId()) {
			System.out.println("TRUE");
		}
		
		return u2;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Logout Success";
	}
	
	@GetMapping("/test")
	public List<Users> test() {
		return u.getAllUsers();
	}
	 
}
