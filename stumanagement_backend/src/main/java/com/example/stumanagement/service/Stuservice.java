package com.example.stumanagement.service;

import com.example.stumanagement.dto.studto;

import java.util.List;

public interface Stuservice
{
    void Addstu(studto stdt);
    void deletestu(String stu_id);
    void updatestu(String stu_id,studto stdt);
    studto getstudent(String stu_id);
    List<studto> getallstu ();
}
