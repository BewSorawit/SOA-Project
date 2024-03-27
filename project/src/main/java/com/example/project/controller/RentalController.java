package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Rental;
import com.example.project.repository.RentalRepository;



@RestController
@RequestMapping("/api/rentals")
public class RentalController {
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@PostMapping
	Rental newRental(@RequestBody Rental newRental) {
		return rentalRepository.save(newRental);
		
	}
	@GetMapping
	List<Rental> getAllRental(){
		return rentalRepository.findAll();
	}
}
