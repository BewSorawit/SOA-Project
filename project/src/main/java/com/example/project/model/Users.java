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

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public Users() {
	}

	
	public Users(int id, String fullName, String userName, String password, String address, String userRole) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.userRole = userRole;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	
}