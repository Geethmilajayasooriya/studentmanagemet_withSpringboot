package com.example.stumanagement.service.impl;

import com.example.stumanagement.dao.studentdao;
import com.example.stumanagement.entities.studententity;
import com.example.stumanagement.exception.studentnotfoundexception;
import com.example.stumanagement.service.Stuservice;
import com.example.stumanagement.dto.studto;
import com.example.stumanagement.util.utildata;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StuserviceIMPL implements Stuservice {
    private final studentdao studao;
    private final Entitydtoconvert enconvert;

    @Override
    public void Addstu(studto stdt) {
        stdt.setStu_id(utildata.generatestuId());
        studao.save(enconvert.convertstudtoToSTENTITY(stdt));




    }

    @Override
    public void deletestu(String stu_id) {

        if(!studao.findById(stu_id).isPresent())
        {
            throw new studentnotfoundexception("Student not found");
        }
       studao.deleteById(stu_id);

    }

    @Override
    public void updatestu(String stu_id, studto stdt) {
        stu_id = stu_id.trim();
        Optional<studententity> foundstudent = studao.findById(stu_id);
        if (!foundstudent.isPresent()) {
            throw new studentnotfoundexception("Student not found");
        }
        /*foundstudent.get().setName(stdt.getName());
        foundstudent.get().setStatus(stdt.getStatus());
        foundstudent.get().setEmail(stdt.getEmail());
        foundstudent.get().setGender(stdt.getGender());
        foundstudent.get().setDepartment(stdt.getDepartment());
        foundstudent.get().setAddress(stdt.getAddress());
        foundstudent.get().setMobileno(stdt.getMobileno()); */

        studententity student = foundstudent.get();
        student.setName(stdt.getName());
        student.setStatus(stdt.getStatus());
        student.setEmail(stdt.getEmail());
        student.setGender(stdt.getGender());
        student.setDepartment(stdt.getDepartment());
        student.setAddress(stdt.getAddress());
        student.setMobileno(stdt.getMobileno());

        studao.save(student);

    }

        @Override
    public studto getstudent(String stu_id) {
        Optional<studententity> foundstudent =studao.findById(stu_id);
        if(!foundstudent.isPresent())
        {
            throw new studentnotfoundexception(" Selected Student not found");
        }
        studententity selectstu = studao.getReferenceById(stu_id);
        studto selstudto = enconvert.convertSTENTITYToDTO(selectstu);

        return selstudto;


    }

    @Override
    public List<studto> getallstu() {


        return enconvert.TOstudentdto(studao.findAll());
    }
}
