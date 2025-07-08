package com.example.stumanagement.service;

import com.example.stumanagement.dto.staffdto;

import java.util.List;

public interface Staffservice {
    void Addstaff( staffdto stf);
    void deletestaff(String idvalue);
    void updatestu(String st,staffdto staffd);
    staffdto getstaff(String st);
    List<staffdto> getallstaff();
}
