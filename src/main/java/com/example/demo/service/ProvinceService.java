package com.example.demo.service;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.entity.Province;
import com.example.demo.entity.User;

import java.util.List;

public interface ProvinceService {
    public void save (ProvinceDTO provinceDTO);

    public void saveAll (List<ProvinceDTO> provinceDTOs);
}
