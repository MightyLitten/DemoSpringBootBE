package com.example.demo.controller;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.service.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictService service;

    @PostMapping("/districts")
    public ResponseEntity<?> add(@RequestBody DistrictDTO districtDTO){
        service.save(districtDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/districts/list")
    public ResponseEntity<?> addAll(@RequestBody List<DistrictDTO> districtDTOs){
        service.saveAll(districtDTOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
