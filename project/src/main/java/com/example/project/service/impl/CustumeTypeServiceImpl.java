package com.example.project.service.impl;

import com.example.project.model.CustumeType;
import com.example.project.repository.CustumeTypeRepository;
import com.example.project.service.CustumeTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustumeTypeServiceImpl implements CustumeTypeService {

    @Autowired
    private CustumeTypeRepository custumeTypeRepository;

    @Override
    public List<CustumeType> getAllCustumeTypes() {
        return custumeTypeRepository.findAll();
    }

    @Override
    public CustumeType getCustumeTypeById(int id) {
        return custumeTypeRepository.findById(id).orElse(null);
    }

    @Override
    public CustumeType createCustumeType(CustumeType custumeType) {
        return custumeTypeRepository.save(custumeType);
    }

    @Override
    public CustumeType updateCustumeType(int id, CustumeType custumeType) {
        if (custumeTypeRepository.existsById(id)) {
            custumeType.setTypeId(id);
            return custumeTypeRepository.save(custumeType);
        }
        return null;
    }

    @Override
    public void deleteCustumeType(int id) {
        custumeTypeRepository.deleteById(id);
    }
}
