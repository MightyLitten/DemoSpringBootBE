package com.example.demo.dto.transformer;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.District;
import com.example.demo.entity.Province;
import com.example.demo.entity.User;
import com.example.demo.entity.Ward;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserTransformer {
    public static UserDTO toDTO(User entity){
        if(Objects.isNull(entity)){
            return null;
        }
    UserDTO userDTO = new UserDTO();
    userDTO.setId(entity.getId());
    userDTO.setEmail(entity.getEmail());
    userDTO.setFullname(entity.getFullname());
    userDTO.setGender(entity.isGender());
    userDTO.setDob(entity.getDob());
    userDTO.setPhone(entity.getPhone());
    userDTO.setProvince(entity.getProvince().getPcode());
    userDTO.setDistrict(entity.getDistrict().getDcode());
    userDTO.setWard(entity.getWard().getWcode());
    userDTO.setAddress(entity.getWard().getWname() + ", " + entity.getDistrict().getDname() + ", " + entity.getProvince().getPname());
    return userDTO;
    }

    public static List<UserDTO> toListDTO(List<User> entities){
        if(Objects.isNull(entities)){
            return null;
        }
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User entity:entities) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(entity.getId());
            userDTO.setEmail(entity.getEmail());
            userDTO.setFullname(entity.getFullname());
            userDTO.setDob(entity.getDob());
            userDTO.setGender(entity.isGender());
            userDTO.setPhone(entity.getPhone());
            userDTO.setProvince(entity.getProvince().getPcode());
            userDTO.setDistrict(entity.getDistrict().getDcode());
            userDTO.setWard(entity.getWard().getWcode());
            userDTO.setAddress(entity.getWard().getWname() + ", " + entity.getDistrict().getDname() + ", " + entity.getProvince().getPname());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    public static User toEntity(UserDTO userDTO){
        if(Objects.isNull(userDTO)){
            return null;
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setFullname(userDTO.getFullname());
        user.setGender(userDTO.isGender());
        user.setDob(userDTO.getDob());
        user.setPhone(userDTO.getPhone());
        Province p = new Province();
        p.setPcode(userDTO.getProvince());
        user.setProvince(p);
        District d = new District();
        d.setDcode(userDTO.getDistrict());
        user.setDistrict(d);
        Ward w = new Ward();
        w.setWcode(userDTO.getWard());
        user.setWard(w);
        return user;
    }
}
