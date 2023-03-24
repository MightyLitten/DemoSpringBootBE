package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ward")
public class Ward {
    @Id
    @Column(name = "wcode")
    private int wcode;
    @Column(name = "wname")
    private String wname;
    @Column(name = "division_type")
    private  String division_type;
    @Column(name = "codename")
    private String codename;
    @Column(name = "dcode")
    private int dcode;

    public Ward() {
    }

    public int getWcode() {
        return wcode;
    }

    public void setWcode(int wcode) {
        this.wcode = wcode;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
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

    public int getDcode() {
        return dcode;
    }

    public void setDcode(int district_code) {
        this.dcode = district_code;
    }
}
