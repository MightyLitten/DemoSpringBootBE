package com.example.demo.serviceImpl;

import com.example.demo.dto.WardDTO;
import com.example.demo.dto.transformer.WardTransformer;
import com.example.demo.repository.WardRepository;
import com.example.demo.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WardServiceImpl implements WardService {
    @Autowired
    private WardRepository repo;
    private WardTransformer transformer = new WardTransformer();

    @Override
    public void save(WardDTO wardDTO) {
        repo.save(transformer.toEntity(wardDTO));
    }

    @Override
    public void saveAll(List<WardDTO> wardDTOs) {
        repo.saveAll(transformer.toListEntities(wardDTOs));
    }

    @Override
    public List<WardDTO> findAll() {
        return transformer.toListDTO(repo.findAll());
    }

    @Override
    public List<WardDTO> findListByDcode(int dcode) {
        return transformer.toListDTO(repo.findByDcode(dcode));
    }

    @Override
    public WardDTO findById(int id) {
        return transformer.toDTO(repo.findById(id).get());
    }
}
