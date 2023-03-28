package com.example.demo.serviceImpl;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.transformer.DistrictTransformer;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository repo;

    @Override
    public void save(DistrictDTO districtDTO) {
        DistrictTransformer transformer = new DistrictTransformer();
        repo.save(transformer.toEntity(districtDTO));
    }

    @Override
    public void saveAll(List<DistrictDTO> districtDTOs) {
        DistrictTransformer transformer = new DistrictTransformer();
        repo.saveAll(transformer.toListEntities(districtDTOs));
    }
}
