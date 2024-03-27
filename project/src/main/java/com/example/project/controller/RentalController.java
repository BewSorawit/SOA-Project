package com.example.project.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Rental;
import com.example.project.repository.RentalRepository;
import com.example.project.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

	@Autowired
	private RentalRepository rentalRepository;
	@Autowired
    private RentalService rentalService;

	@PostMapping
	Rental newRental(@RequestBody Rental newRental) {
		return rentalRepository.save(newRental);

	}

	@GetMapping
	List<Rental> getAllRental() {
		return rentalRepository.findAll();
	}

	@PostMapping("/reserve")
    public ResponseEntity<String> createRental(@RequestBody CreateRentalRequest request) {
        try {
            rentalService.createRental(request.getCustomerId(), request.getEmployeeId(), request.getDueDate());
            return ResponseEntity.ok("Rental created successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request");
        }
    }

	public static class CreateRentalRequest {
		private int customerId;
		private int employeeId;
		private Date dueDate;

		// getters and setters
		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}
	}
}
