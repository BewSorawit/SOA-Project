package com.example.project.service;

import java.util.List;

import com.example.project.model.*;

public interface UsersService {

	 List<Users> getAllUsers();
	 Users login(Users user);
	 Users getByUserName(Users user);
	 void save(Users user);
	 void update(Users user);
	 void delete(Users user);
}
