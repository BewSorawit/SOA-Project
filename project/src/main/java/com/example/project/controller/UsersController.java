package com.example.project.controller;

import com.example.project.model.Users;
import com.example.project.service.UsersService;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	@Autowired
	private UsersService u;

	@PostMapping("/auth")
	public String login(@RequestBody Users user, HttpSession session) {
		if (session.getAttribute("USER_OBJ") != null) {
			session.invalidate();
		}

		if (u.getByUserName(user) != null) {

			Users u2 = u.login(user);
			if(u2!=null) {

			session.setAttribute("USER_OBJ", u2);

			return "Login as " + u2.getUserRole();
			}
			
			return "Wrong Password!!";

		}

		return "User name not Found";
	}

	@GetMapping("/authCheck")
	public String login2(@RequestBody Users user, HttpSession session) {

		Users uss = (Users) session.getAttribute("USER_OBJ");

		if (uss == null) {
			System.out.println("FALSE");
			return "Sorry Auth Fail!!";
		}
			System.out.println("TRUE");
			return "Hello " + uss.getUserName() + " AS Role " + uss.getUserRole();


	}
	@GetMapping("/")
	public List<Users> getAll(HttpSession session) {
		List<Users> l = new ArrayList<Users>();
				Users uss = (Users) session.getAttribute("USER_OBJ");
		if (uss != null) {
			if(uss.getUserRole().equals("ADMIN")) {
				return u.getAllUsers();
			}
			System.out.println("FALSE");
			l.add(new Users("NEED ADMIN ROLE!!!",404));
			return l;

		}
		l.add(new Users("Not AUTH",40123));
		return l;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "Logout Success";
	}

}
