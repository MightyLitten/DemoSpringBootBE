package com.example.demo.service;

import com.example.demo.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    public void save(DistrictDTO districtDTO);

    public void saveAll(List<DistrictDTO> districtDTOs);
}
