package com.example.demo.service;

import com.example.demo.dto.ProvinceDTO;

import java.util.List;

public interface ProvinceService {
    public void save (ProvinceDTO provinceDTO);

    public void saveAll (List<ProvinceDTO> provinceDTOs);

    public List<ProvinceDTO> findAll(Integer depth);

    public ProvinceDTO findByCode(int id, Integer depth);
}
