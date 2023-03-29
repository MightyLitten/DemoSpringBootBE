package com.example.demo.serviceImpl;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.dto.transformer.ProvinceTransformer;
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
    private ProvinceTransformer transformer = new ProvinceTransformer();

    @Override
    public void save(ProvinceDTO provinceDTO) {
        repo.save(transformer.toEntity(provinceDTO));
    }

    @Override
    public void saveAll(List<ProvinceDTO> provinceDTOs) {
        repo.saveAll(transformer.toListEntities(provinceDTOs));
    }

    @Override
    public List<ProvinceDTO> findAll(Integer depth) {
        return transformer.toListDTO(repo.findAll(),depth);
    }

    @Override
    public ProvinceDTO findByCode(int code, Integer depth) {
        return transformer.toDTO(repo.findById(code).get(),depth);
    }
}
