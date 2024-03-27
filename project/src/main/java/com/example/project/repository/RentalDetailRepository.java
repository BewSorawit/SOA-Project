package com.example.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.model.RentalDetail;


public interface RentalDetailRepository extends JpaRepository<RentalDetail,Integer> {


}
