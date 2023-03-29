package com.example.demo.dto.transformer;

import com.example.demo.dto.ProvinceDTO;
import com.example.demo.entity.Province;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProvinceTransformer {
    private static DistrictTransformer transformer = new DistrictTransformer();

    public static ProvinceDTO toDTO(Province entity,Integer depth){
        if(Objects.isNull(entity)){
            return null;
        }
        ProvinceDTO provinceDTO = new ProvinceDTO();
        provinceDTO.setCode(entity.getPcode());
        provinceDTO.setName(entity.getPname());
        provinceDTO.setDivision_type(entity.getDivision_type());
        provinceDTO.setCodename(entity.getCodename());
        provinceDTO.setPhone_code(entity.getPhone_code());
        if(depth==null||depth!=2)provinceDTO.setDistricts(new ArrayList<>());
        else provinceDTO.setDistricts(transformer.toListDTO(entity.getDistricts(),0));
        return provinceDTO;
    }

    public static List<ProvinceDTO> toListDTO(List<Province> entities, Integer depth){
        if(Objects.isNull(entities)){
            return null;
        }
        List<ProvinceDTO> ProvinceDTOList = new ArrayList<>();
        for (Province entity:entities) {
            ProvinceDTO provinceDTO = toDTO(entity,depth);
            ProvinceDTOList.add(provinceDTO);
        }

        return ProvinceDTOList;
    }

    public static List<Province> toListEntities(List<ProvinceDTO> provinceDTOs){
        if(Objects.isNull(provinceDTOs)){
            return null;
        }
        List<Province> entities = new ArrayList<>();
        for (ProvinceDTO provinceDTO:provinceDTOs) {
            Province province = toEntity(provinceDTO);
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
