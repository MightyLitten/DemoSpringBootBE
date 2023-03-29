package com.example.demo.controller;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.WardDTO;
import com.example.demo.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WardController {
    @Autowired
    private WardService service;

    @GetMapping("/w")
    public ResponseEntity<?> findAll(){
        List<WardDTO> wardDTOS = service.findAll();
        return new ResponseEntity<>(wardDTOS,HttpStatus.OK);
    }

    @GetMapping("/w/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        WardDTO wardDTO = service.findById(id);
        return new ResponseEntity<>(wardDTO,HttpStatus.OK);
    }
}
