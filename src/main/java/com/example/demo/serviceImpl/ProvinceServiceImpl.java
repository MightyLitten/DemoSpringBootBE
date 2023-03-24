package com.example.demo.serviceImpl;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.dto.transformer.ProvinceTransformer;
import com.example.demo.entity.Province;
import com.example.demo.repository.ProvinceRepository;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository repo;
    @Override
    public void save(ProvinceDTO provinceDTO) {
        ProvinceTransformer transformer = new ProvinceTransformer();
        repo.save(transformer.toEntity(provinceDTO));
    }

    @Override
    public void saveAll(List<ProvinceDTO> provinceDTOs) {
        ProvinceTransformer transformer = new ProvinceTransformer();
        repo.saveAll(transformer.toListEntities(provinceDTOs));
    }
}
