package com.example.project.service;

import java.util.List;

import com.example.project.model.*;

public interface UsersService {

	 List<Users> getAllUsers();
	 Users login(Users user);
	 
}
