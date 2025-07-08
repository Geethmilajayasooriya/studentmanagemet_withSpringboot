package com.example.stumanagement.service;

import com.example.stumanagement.dto.coursedto;

import java.util.List;

public interface Courseservice {
    void Addcourse(coursedto cou);
    void deletecourse( String idvalue);
    void updatecourse (String st,coursedto soursefd);
    coursedto getcourse (String st);
    List<coursedto> getallcourse ();
}
