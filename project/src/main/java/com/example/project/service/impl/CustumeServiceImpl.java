package com.example.project.service.impl;

import com.example.project.model.Custume;
import com.example.project.repository.CustumeRepository;
import com.example.project.service.CustumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustumeServiceImpl implements CustumeService {

    @Autowired
    private CustumeRepository custumeRepository;

    @Override
    public List<Custume> getAllCustumes() {
        return custumeRepository.findAll();
    }

    @Override
    public Custume getCustumeById(int id) {
        return custumeRepository.findById(id).orElse(null);
    }

    @Override
    public Custume createCustume(Custume custume) {
        return custumeRepository.save(custume);
    }

    @Override
    public Custume updateCustume(int id, Custume custume) {
        Custume existingCustume = custumeRepository.findById(id).orElse(null);
        if (existingCustume != null) {
            custume.setCostumeId(id);
            return custumeRepository.save(custume);
        }
        return null;
    }

    @Override
    public void deleteCustume(int id) {
        custumeRepository.deleteById(id);
    }
}
