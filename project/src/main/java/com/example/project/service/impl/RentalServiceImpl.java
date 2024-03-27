package com.example.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.model.Rental;
import com.example.project.model.Users;
import com.example.project.repository.RentalRepository;
import com.example.project.repository.UsersRepository;
import com.example.project.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final UsersRepository userRepository;

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository, UsersRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Rental createRental(int customerId, int employeeId, Date dueDate) {
        Users customer = userRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Users employee = userRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setEmployee(employee);
        rental.setOrderDate(new Date());
        rental.setDueDate(dueDate);
        rental.setRentStatus("Pending");

        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> getAllRental() {
        return rentalRepository.findAll();
    }
}
