package com.example.demo.serviceImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.transformer.UserTransformer;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    UserTransformer transformer = new UserTransformer();

    @Override
    public void save(UserDTO userDTO) {
        repo.save(transformer.toEntity(userDTO));
    }

    @Override
    public UserDTO get(Integer id) {
        return transformer.toDTO(repo.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<UserDTO> findByKeyword(String keyword) {

        return transformer.toListDTO(repo.findByKeyword(keyword));
    }

    @Override
    public List<UserDTO> findByEmail(String keyword, int id) {
        return transformer.toListDTO(repo.findByEmail(keyword,id));
    }

    @Override
    public List<UserDTO> findByPhone(String keyword, int id) {
        return transformer.toListDTO(repo.findByPhone(keyword,id));
    }

}
