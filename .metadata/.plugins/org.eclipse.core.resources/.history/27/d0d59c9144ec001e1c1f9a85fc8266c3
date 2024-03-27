package com.example.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "custume")
public class Custume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costume_id")
    private int costumeId;

    @Column(name = "costume_name")
    private String costumeName;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CustumeType custumeType;

    @Column(name = "status")
    private String status;

    public int getCostumeId() {
        return costumeId;
    }

    public void setCostumeId(int costumeId) {
        this.costumeId = costumeId;
    }

    public String getCostumeName() {
        return costumeName;
    }

    public void setCostumeName(String costumeName) {
        this.costumeName = costumeName;
    }

    public CustumeType getCustumeType() {
        return custumeType;
    }

    public void setCustumeType(CustumeType custumeType) {
        this.custumeType = custumeType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
