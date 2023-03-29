package com.example.demo.service;

import com.example.demo.dto.DistrictDTO;

import java.util.List;

public interface DistrictService {

    public void save(DistrictDTO districtDTO);

    public void saveAll(List<DistrictDTO> districtDTOs);

    public List<DistrictDTO> findAll(Integer depth);

    public DistrictDTO findById(int id,Integer depth);

    public List<DistrictDTO> findListByProvinceId(int pcode);
}
