package com.example.demo.controller;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DistrictController {
    @Autowired
    private DistrictService service;

    @GetMapping("/d")
    public ResponseEntity<?> findAll(@RequestParam(required = false) Integer depth){
        List<DistrictDTO> districtDTOS = service.findAll(depth);
        return new ResponseEntity<>(districtDTOS,HttpStatus.OK);
    }

    @GetMapping("/d/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id,@RequestParam(required = false) Integer depth){
        DistrictDTO districtDTO = service.findById(id,depth);
        return new ResponseEntity<>(districtDTO,HttpStatus.OK);
    }

}
