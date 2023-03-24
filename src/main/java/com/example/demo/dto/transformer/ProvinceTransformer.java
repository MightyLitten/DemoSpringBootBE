package com.example.demo.dto.transformer;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.dto.ProvinceDTO;
import com.example.demo.entity.Province;
import com.example.demo.entity.Province;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProvinceTransformer {

    public static ProvinceDTO toDTO(Province entity){
        if(Objects.isNull(entity)){
            return null;
        }
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setCode(entity.getPcode());
        provinceDTO.setName(entity.getPname());
        provinceDTO.setDivision_type(entity.getDivision_type());
        provinceDTO.setCodename(entity.getCodename());
        provinceDTO.setPhone_code(entity.getPhone_code());
        return provinceDTO;
    }

    public static List<ProvinceDTO> toListDTO(List<Province> entities){
        if(Objects.isNull(entities)){
            return null;
        }
        List<ProvinceDTO> ProvinceDTOList = new ArrayList<>();
        for (Province entity:entities) {
            ProvinceDTO districtDTO = new ProvinceDTO();
            districtDTO.setCode(entity.getPcode());
            districtDTO.setName(entity.getPname());
            districtDTO.setDivision_type(entity.getDivision_type());
            districtDTO.setCodename(entity.getCodename());
            districtDTO.setPhone_code(entity.getPcode());
            ProvinceDTOList.add(districtDTO);
        }

        return ProvinceDTOList;
    }

    public static List<Province> toListEntities(List<ProvinceDTO> provinceDTOs){
        if(Objects.isNull(provinceDTOs)){
            return null;
        }
        List<Province> entities = new ArrayList<>();
        for (ProvinceDTO provinceDTO:provinceDTOs) {
            Province province = new Province();
            province.setPname(provinceDTO.getName());
            province.setPcode(provinceDTO.getCode());
            province.setDivision_type(provinceDTO.getDivision_type());
            province.setCodename(provinceDTO.getCodename());
            province.setPhone_code(provinceDTO.getPhone_code());
            entities.add(province);
        }

        return entities;
    }
    public static Province toEntity(ProvinceDTO provinceDTO){
        if(Objects.isNull(provinceDTO)){
            return null;
        }
        Province province = new Province();
        province.setPname(provinceDTO.getName());
        province.setPcode(provinceDTO.getCode());
        province.setDivision_type(provinceDTO.getDivision_type());
        province.setCodename(provinceDTO.getCodename());
        province.setPhone_code(provinceDTO.getPhone_code());
        return province;
    }

}
