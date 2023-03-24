package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Date;

@Data
public class UserDTO {
    private int id;
    private String email;
    private  String fullname;
    private boolean gender;
    private Date dob;
    private String phone;
    private int province;
    private int district;
    private int ward;
    private String address;
}
