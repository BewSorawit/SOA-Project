package com.example.project.service;

import java.util.Date;
import java.util.List;
import com.example.project.model.Rental;

public interface RentalService {
    Rental createRental(int customerId, int employeeId, Date dueDate);

    List<Rental> getAllRental();
}
