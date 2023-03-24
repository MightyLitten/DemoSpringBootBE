package com.example.demo.dto.transformer;

import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.DistrictDTO;
import com.example.demo.dto.ProvinceDTO;
import com.example.demo.entity.District;
import com.example.demo.entity.Province;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DistrictTransformer {

    public static DistrictDTO toDTO(District entity){
        if(Objects.isNull(entity)){
            return null;
        }
        DistrictDTO districtDTO = new DistrictDTO();
        districtDTO.setCode(entity.getDcode());
        districtDTO.setName(entity.getDname());
        districtDTO.setDivision_type(entity.getDivision_type());
        districtDTO.setCodename(entity.getCodename());
        districtDTO.setProvince_code(entity.getPcode());
        return districtDTO;
    }
    public static List<DistrictDTO> toListDTO(List<District> entities){
        if(Objects.isNull(entities)){
            return null;
        }
        List<DistrictDTO> DistrictDTOList = new ArrayList<>();
        for (District entity:entities) {
            DistrictDTO districtDTO = new DistrictDTO();
            districtDTO.setCode(entity.getDcode());
            districtDTO.setName(entity.getDname());
            districtDTO.setDivision_type(entity.getDivision_type());
            districtDTO.setCodename(entity.getCodename());
            districtDTO.setProvince_code(entity.getPcode());
            DistrictDTOList.add(districtDTO);
        }

        return DistrictDTOList;
    }

    public static List<District> toListEntities(List<DistrictDTO> districtDTOs){
        if(Objects.isNull(districtDTOs)){
            return null;
        }
        List<District> entities = new ArrayList<>();
        for (DistrictDTO districtDTO:districtDTOs) {
            District district = new District();
            district.setDname(districtDTO.getName());
            district.setDcode(districtDTO.getCode());
            district.setDivision_type(districtDTO.getDivision_type());
            district.setCodename(districtDTO.getCodename());
            district.setPcode(districtDTO.getProvince_code());
            entities.add(district);
        }

        return entities;
    }

    public static District toEntity(DistrictDTO districtDTO){
        if(Objects.isNull(districtDTO)){
            return null;
        }
        District district = new District();
        district.setDname(districtDTO.getName());
        district.setDcode(districtDTO.getCode());
        district.setDivision_type(districtDTO.getDivision_type());
        district.setCodename(districtDTO.getCodename());
        district.setPcode(districtDTO.getProvince_code());
        return district;
    }
}
