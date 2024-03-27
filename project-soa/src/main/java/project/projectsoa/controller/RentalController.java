package project.projectsoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import project.projectsoa.model.Rental;
import project.projectsoa.repository.RentalRepository;

@RestController
public class RentalController {
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@PostMapping("/rental")
	Rental newRental(@RequestBody Rental newRental) {
		return rentalRepository.save(newRental);
		
	}
	@GetMapping("/rentalist")
	List<Rental> getAllRental(){
		return rentalRepository.findAll();
	}
}