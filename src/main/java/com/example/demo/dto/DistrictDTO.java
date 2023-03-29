package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class DistrictDTO {
    private String name;
    private int code;
    private  String division_type;
    private String codename;
    private int province_code;
    private List<WardDTO> wards;
}
