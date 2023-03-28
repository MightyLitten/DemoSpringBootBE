package com.example.demo.controller;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.service.ProvinceService;
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
public class ProvinceController {

    @Autowired
    private ProvinceService service;

    @PostMapping("/provinces")
    public ResponseEntity<?> add(@RequestBody ProvinceDTO provinceDTO){
        service.save(provinceDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/provinces/list")
    public ResponseEntity<?> addAll(@RequestBody List<ProvinceDTO> provinceDTOs){
        service.saveAll(provinceDTOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
