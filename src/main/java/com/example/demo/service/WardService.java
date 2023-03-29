package com.example.demo.service;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.WardDTO;

import java.util.List;

public interface WardService {
    public void save (WardDTO wardDTO);

    public void saveAll (List<WardDTO> wardDTOs);

    public List<WardDTO> findAll();

    public List<WardDTO> findListByDcode(int dcode);

    public WardDTO findById(int id);

}
