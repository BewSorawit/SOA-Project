package project.projectsoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import project.projectsoa.model.Rental;
import project.projectsoa.repository.RentalRepository;

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
	@GetMapping("/{id}")
	Rental getRentalById(@PathVariable Integer id){
		return rentalRepository.findById(id).orElseThrow();
	}
	
	@PutMapping("/{id}")
	Rental updateRepository(@RequestBody Rental newRental,@PathVariable Integer id) {
		return rentalRepository.findById(id)
				.map(Rental -> {
					Rental.setUserByCusId(newRental.getUserByCusId());
					Rental.setUserByEmpId(newRental.getUserByEmpId());
					Rental.setOrderDate(newRental.getOrderDate());
					Rental.setDueDate(newRental.getDueDate());
					Rental.setReturnDate(newRental.getReturnDate());
					Rental.setRentStatus(newRental.getRentStatus());
					Rental.setPaymentStatus(newRental.getPaymentStatus());
					return rentalRepository.save(Rental);
				}).orElseThrow();
	}
}
