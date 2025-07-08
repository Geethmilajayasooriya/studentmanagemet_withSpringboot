package com.example.stumanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class studto implements Serializable {

    private String stu_id;
    private String name;
    private String address;
    private String mobileno;
    private String email;
    private String gender;

    private String department;
    private String status;
/*
    public studto() {
    }

    public studto( Integer stu_id, String name, String address, String mobileno, String email, String gender,String department, String status) {

        this.stu_id = stu_id;
        this.name = name;
        this.address = address;
        this.mobileno = mobileno;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.status = status;
    }

    @Override
    public String toString() {
        return "studto{" +
                "stu_id=" + stu_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileno='" + mobileno + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  */
}
