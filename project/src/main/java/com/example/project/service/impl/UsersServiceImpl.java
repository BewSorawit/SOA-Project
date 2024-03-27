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
	public Users login(Users user) {
		return u.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}
	@Override
	public Users getByUserName(Users user) {
		return u.findByUserName(user.getUserName());
	}
	@Override
	public void save(Users user) {
		u.save(user);
	}
	@Override
	public void update(Users user) {
		Users u2 = u.findById(user.getId()).get() ;
		u2.setFullName(user.getFullName());
		u2.setAddress(user.getAddress());
		u2.setPassword(user.getPassword());
		u2.setUserName(user.getUserName());
		u.save(u2);
	}
	
	@Override
	public void delete(Users user) {
		u.deleteById(user.getId());
	}

}
