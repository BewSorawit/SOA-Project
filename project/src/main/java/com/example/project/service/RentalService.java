package com.example.project.service;

import java.util.Date;
import java.util.List;
import com.example.project.model.Rental;

public interface RentalService {
    Rental createRental(int customerId, int employeeId, Date dueDate);

    Rental getRentalById(int rentalId);

    Rental updateRental(int rentalId, Rental rentalDetails);

    void deleteRental(int rentalId);

    List<Rental> getAllRental();
}
