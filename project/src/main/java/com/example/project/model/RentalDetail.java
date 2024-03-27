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

    public int getRdId() {
        return rdId;
    }

    public void setRdId(int rdId) {
        this.rdId = rdId;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Custume getCustume() {
        return custume;
    }

    public void setCustume(Custume custume) {
        this.custume = custume;
    }


}