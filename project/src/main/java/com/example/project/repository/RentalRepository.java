package com.example.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.model.Rental;


public interface RentalRepository extends JpaRepository<Rental,Integer> {

}
