package com.example.demo.serviceImpl;

import com.example.demo.dto.WardDTO;
import com.example.demo.dto.transformer.WardTransformer;
import com.example.demo.entity.Ward;
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

    @Override
    public void save(WardDTO wardDTO) {
        WardTransformer transformer = new WardTransformer();
        repo.save(transformer.toEntity(wardDTO));
    }

    @Override
    public void saveAll(List<WardDTO> wardDTOs) {
        WardTransformer transformer = new WardTransformer();
        repo.saveAll(transformer.toListEntities(wardDTOs));
    }
}
