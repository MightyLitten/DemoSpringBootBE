package com.example.demo.controller;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.dto.transformer.ProvinceTransformer;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {

    @Autowired
    private ProvinceService service;

    @GetMapping("/p")
    public ResponseEntity<?> findAll(@RequestParam(required = false) Integer depth){
        List<ProvinceDTO> provinceDTOS = service.findAll(depth);
        return new ResponseEntity<>(provinceDTOS,HttpStatus.OK);
    }

    @GetMapping("/p/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id,@RequestParam(required = false) Integer depth){
        ProvinceDTO provinceDTO = service.findByCode(id,depth);
        return new ResponseEntity<>(provinceDTO,HttpStatus.OK);
    }
}
