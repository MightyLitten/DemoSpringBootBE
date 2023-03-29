package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "district")
public class District {
    @Id
    @Column(name = "dcode")
    private int dcode;
    @Column(name = "dname")
    private String dname;
    @Column(name = "division_type")
    private  String division_type;
    @Column(name = "codename")
    private String codename;
    @Column(name = "pcode")
    private int pcode;
    @OneToMany
    @JoinColumn(name = "dcode",referencedColumnName = "dcode")
    private List<Ward> wards;

    public District() {
    }

    public int getDcode() {
        return dcode;
    }

    public void setDcode(int dcode) {
        this.dcode = dcode;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDivision_type() {
        return division_type;
    }

    public void setDivision_type(String division_type) {
        this.division_type = division_type;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int phone_code) {
        this.pcode = phone_code;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }
}
