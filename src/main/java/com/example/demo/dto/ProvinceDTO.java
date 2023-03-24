package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ProvinceDTO {
    private String name;
    private int code;
    private  String division_type;
    private String codename;
    private int phone_code;
}
