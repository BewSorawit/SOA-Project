package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.*;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	Users findByUserNameAndPassword(String userName,String password);

}
