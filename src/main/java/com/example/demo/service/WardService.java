package com.example.demo.service;

import com.example.demo.dto.WardDTO;
import com.example.demo.entity.Ward;

import java.util.List;

public interface WardService {
    public void save (WardDTO wardDTO);

    public void saveAll (List<WardDTO> wardDTOs);
}
