package com.example.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.Users;
import com.example.project.repository.UsersRepository;
import com.example.project.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersRepository u;
	
	@Override
	public List<Users> getAllUsers(){
		return u.findAll();
	}
	
	@Override
	public Users login(String username,String pwd) {
		return u.findByUserNameAndPassword(username, pwd);
	}

}
