package com.example.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cus_id")
    private int id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "userName")
    private String userName;

    @Column(name = "pwd")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "user_role")
    private String userRole;

    // Constructors, getters, and setters
}