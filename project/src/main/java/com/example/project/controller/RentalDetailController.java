package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.RentalDetail;
import com.example.project.repository.RentalDetailRepository;

@RestController
@RequestMapping("/api/rentaldetail")
public class RentalDetailController {

	@Autowired
	private RentalDetailRepository rentalDetailRepository;

	@PostMapping
	RentalDetail newRentalDetail(@RequestBody RentalDetail newRentalDetail) {
		return rentalDetailRepository.save(newRentalDetail);
	}

	@GetMapping
	List<RentalDetail> getAllRentalDetail() {
		return rentalDetailRepository.findAll();
	}

}
