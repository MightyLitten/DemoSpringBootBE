package com.example.demo.controller;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.WardDTO;
import com.example.demo.entity.Ward;
import com.example.demo.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WardController {
    @Autowired
    private WardService service;

    @PostMapping("/wards")
    public ResponseEntity<?> add(@RequestBody WardDTO wardDTO){
        service.save(wardDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/wards/list")
    public ResponseEntity<?> addAll(@RequestBody List<WardDTO> wardDTOs){
        service.saveAll(wardDTOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
