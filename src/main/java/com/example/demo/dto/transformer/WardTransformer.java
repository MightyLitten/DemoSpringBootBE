package com.example.demo.dto.transformer;

import com.example.demo.dto.WardDTO;
import com.example.demo.entity.Ward;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WardTransformer {
    public static WardDTO toDTO(Ward entity){
        if(Objects.isNull(entity)){
            return null;
        }
        WardDTO wardDTO = new WardDTO();
        wardDTO.setCode(entity.getWcode());
        wardDTO.setName(entity.getWname());
        wardDTO.setDivision_type(entity.getDivision_type());
        wardDTO.setCodename(entity.getCodename());
        wardDTO.setDistrict_code(entity.getDcode());
        return wardDTO;
    }
    public static List<WardDTO> toListDTO(List<Ward> entities){
        if(Objects.isNull(entities)){
            return null;
        }
        List<WardDTO> WardDTOList = new ArrayList<>();
        for (Ward entity:entities) {
            WardDTO districtDTO = new WardDTO();
            districtDTO.setCode(entity.getWcode());
            districtDTO.setName(entity.getWname());
            districtDTO.setDivision_type(entity.getDivision_type());
            districtDTO.setCodename(entity.getCodename());
            districtDTO.setDistrict_code(entity.getDcode());
            WardDTOList.add(districtDTO);
        }

        return WardDTOList;
    }

    public static List<Ward> toListEntities(List<WardDTO> wardDTOs){
        if(Objects.isNull(wardDTOs)){
            return null;
        }
        List<Ward> entities = new ArrayList<>();
        for (WardDTO wardDTO:wardDTOs) {
            Ward ward = new Ward();
            ward.setWname(wardDTO.getName());
            ward.setWcode(wardDTO.getCode());
            ward.setDivision_type(wardDTO.getDivision_type());
            ward.setCodename(wardDTO.getCodename());
            ward.setDcode(wardDTO.getDistrict_code());
            entities.add(ward);
        }

        return entities;
    }

    public static Ward toEntity(WardDTO wardDTO){
        if(Objects.isNull(wardDTO)){
            return null;
        }
        Ward ward = new Ward();
        ward.setWname(wardDTO.getName());
        ward.setWcode(wardDTO.getCode());
        ward.setDivision_type(wardDTO.getDivision_type());
        ward.setCodename(wardDTO.getCodename());
        ward.setDcode(wardDTO.getDistrict_code());
        return ward;
    }
}
