package com.example.project.controller;

import com.example.project.model.Custume;
import com.example.project.service.CustumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custumes")
public class CustumeController {

    @Autowired
    private CustumeService custumeService;

    @GetMapping
    public ResponseEntity<List<Custume>> getAllCustumes() {
        List<Custume> custumes = custumeService.getAllCustumes();
        return new ResponseEntity<>(custumes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Custume> getCustumeById(@PathVariable("id") int id) {
        Custume custume = custumeService.getCustumeById(id);
        if (custume != null) {
            return new ResponseEntity<>(custume, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Custume> createCustume(@RequestBody Custume custume) {
        Custume createdCustume = custumeService.createCustume(custume);
        return new ResponseEntity<>(createdCustume, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Custume> updateCustume(@PathVariable("id") int id, @RequestBody Custume custume) {
        Custume updatedCustume = custumeService.updateCustume(id, custume);
        if (updatedCustume != null) {
            return new ResponseEntity<>(updatedCustume, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustume(@PathVariable("id") int id) {
        custumeService.deleteCustume(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
