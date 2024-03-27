package com.example.project.service;

import java.util.List;

import com.example.project.model.Custume;

public interface CustumeService {
    List<Custume> getAllCustumes();
    Custume getCustumeById(int id);
    Custume createCustume(Custume custume);
    Custume updateCustume(int id, Custume custume);
    void deleteCustume(int id);
}

