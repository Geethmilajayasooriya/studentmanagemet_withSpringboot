package com.example.stumanagement.service.impl;

import com.example.stumanagement.dao.coursedao;
import com.example.stumanagement.dto.coursedto;
import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.entities.courseentity;
import com.example.stumanagement.entities.staffentity;
import com.example.stumanagement.exception.coursenotfoundexception;
import com.example.stumanagement.exception.membernotfoundexception;
import com.example.stumanagement.service.Courseservice;
import com.example.stumanagement.util.Entconvert;
import com.example.stumanagement.util.utildata;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseserviceIMPL implements Courseservice {
    private final coursedao coudao;
    private final Entconvert enconvert;

    @Override
    public void Addcourse(coursedto cou) {
  cou.setCourseid(utildata.courseId());
  coudao.save(enconvert.convertDtoTocourseentity(cou));
    }

    @Override
    public void deletecourse(String idvalue) {
        if(!coudao.findById(idvalue).isPresent())
        {
            throw new coursenotfoundexception("course not found");
        }
        coudao.deleteById(idvalue);
    }

    @Override
    public void updatecourse(String st, coursedto coursefd) {

        st = st.trim();
        Optional<courseentity> foundcourse = coudao.findById(st);
        if (!foundcourse.isPresent()) {
            throw new coursenotfoundexception("course member not found");
        }

        courseentity course = foundcourse.get();
        course.setName(coursefd.getName());
        course.setSemester(coursefd.getSemester());
        course.setCredit(coursefd.getCredit());
        course.setStatus(coursefd.getStatus());
        course.setCompulsory(coursefd.getCompulsory());
        course.setDepartment(coursefd.getDepartment());
        coudao.save(course);
    }




    @Override
    public coursedto getcourse(String st) {
        Optional<courseentity> foundcourse =coudao.findById(st);
        if(!foundcourse.isPresent())
        {
            throw new coursenotfoundexception(" Selected course not found");
        }
        courseentity selectcourse = coudao.getReferenceById(st);
        coursedto selstadto = enconvert.convertcourseentityTocoursedto(selectcourse);

        return selstadto;
    }

    @Override
    public List<coursedto> getallcourse() {

        return enconvert.tocourseDtolist(coudao.findAll());
    }
}
