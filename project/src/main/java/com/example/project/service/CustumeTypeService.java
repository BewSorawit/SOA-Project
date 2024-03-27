package com.example.project.service;

import com.example.project.model.CustumeType;

import java.util.List;

public interface CustumeTypeService {
    List<CustumeType> getAllCustumeTypes();

    CustumeType getCustumeTypeById(int id);

    CustumeType createCustumeType(CustumeType custumeType);

    CustumeType updateCustumeType(int id, CustumeType custumeType);

    void deleteCustumeType(int id);
}