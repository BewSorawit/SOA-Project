package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.Custume;

@Repository
public interface CustumeRepository extends JpaRepository<Custume, Integer> {
}
