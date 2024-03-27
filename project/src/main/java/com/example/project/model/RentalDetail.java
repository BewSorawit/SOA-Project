package com.example.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rentaldetail")
public class RentalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rd_id")
    private int rdId;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name = "costume_id")
    private Custume custume;

    // Getters and setters
}