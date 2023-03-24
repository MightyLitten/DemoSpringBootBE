package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users/search")
    public List<UserDTO> findByKeyword(@RequestParam(required = false) String keyword) {
        return service.findByKeyword(keyword);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> get(@PathVariable Integer id) {
        try {
            UserDTO userDTO = service.get(id);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<?> add(@RequestBody UserDTO userDTO) {
        int id = -1;
        if (!service.findByEmail(userDTO.getEmail(),id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!service.findByPhone(userDTO.getPhone(),id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.save(userDTO);
            return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        if (!service.findByEmail(userDTO.getEmail(),id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!service.findByPhone(userDTO.getPhone(),id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDTO existUser = service.get(id);
        if (existUser == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            service.save(userDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
