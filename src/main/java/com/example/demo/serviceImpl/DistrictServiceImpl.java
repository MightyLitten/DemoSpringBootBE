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
    private DistrictTransformer transformer = new DistrictTransformer();

    @Override
    public void save(DistrictDTO districtDTO) {
        repo.save(transformer.toEntity(districtDTO));
    }

    @Override
    public void saveAll(List<DistrictDTO> districtDTOs) {
        repo.saveAll(transformer.toListEntities(districtDTOs));
    }

    @Override
    public List<DistrictDTO> findAll(Integer depth) {
        return transformer.toListDTO(repo.findAll(),depth);
    }

    @Override
    public DistrictDTO findById(int id, Integer depth) {
        return transformer.toDTO(repo.findById(id).get(),depth);
    }

    @Override
    public List<DistrictDTO> findListByProvinceId(int pcode) {
        return transformer.toListDTO(repo.findByPcode(pcode),0);
    }
}
