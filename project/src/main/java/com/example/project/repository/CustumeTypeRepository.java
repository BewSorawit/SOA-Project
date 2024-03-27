package com.example.project.repository;

import com.example.project.model.CustumeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustumeTypeRepository extends JpaRepository<CustumeType, Integer> {
}
