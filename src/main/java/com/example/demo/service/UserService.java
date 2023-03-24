package com.example.demo.service;

import com.example.demo.dto.UserDTO;

import java.util.List;

public interface UserService {
    public void save(UserDTO userDTO);

    public UserDTO get(Integer id);

    public void delete(Integer id);

    public List<UserDTO> findByKeyword(String keyword);

    public List<UserDTO> findByEmail(String keyword, int id);

    public List<UserDTO> findByPhone(String keyword, int id);
}
