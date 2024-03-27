package com.example.project.controller;

import com.example.project.model.CustumeType;
import com.example.project.service.CustumeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/custume-types")
public class CustumeTypeController {

    @Autowired
    private CustumeTypeService custumeTypeService;

    @GetMapping
    public ResponseEntity<List<CustumeType>> getAllCustumeTypes() {
        List<CustumeType> custumeTypes = custumeTypeService.getAllCustumeTypes();
        return new ResponseEntity<>(custumeTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustumeType> getCustumeTypeById(@PathVariable("id") int id) {
        CustumeType custumeType = custumeTypeService.getCustumeTypeById(id);
        if (custumeType != null) {
            return new ResponseEntity<>(custumeType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustumeType> createCustumeType(@RequestBody CustumeType custumeType) {
        CustumeType createdCustumeType = custumeTypeService.createCustumeType(custumeType);
        return new ResponseEntity<>(createdCustumeType, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustumeType> updateCustumeType(@PathVariable("id") int id, @RequestBody CustumeType custumeType) {
        CustumeType updatedCustumeType = custumeTypeService.updateCustumeType(id, custumeType);
        if (updatedCustumeType != null) {
            return new ResponseEntity<>(updatedCustumeType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustumeType(@PathVariable("id") int id) {
        custumeTypeService.deleteCustumeType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
