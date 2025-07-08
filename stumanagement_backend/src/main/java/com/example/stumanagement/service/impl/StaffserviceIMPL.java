package com.example.stumanagement.service.impl;

import com.example.stumanagement.dao.staffdao;
import com.example.stumanagement.dto.Role;
import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.dto.studto;
import com.example.stumanagement.entities.staffentity;
import com.example.stumanagement.entities.studententity;
import com.example.stumanagement.exception.membernotfoundexception;
import com.example.stumanagement.exception.studentnotfoundexception;
import com.example.stumanagement.service.Staffservice;
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
public class StaffserviceIMPL implements Staffservice {
    private final staffdao stdao;
    private final Entconvert entityconvert;
    @Override
    public void Addstaff(staffdto stf) {
           stf.setStaffid(utildata.generatestaffId());
           stdao.save(entityconvert.convertDtoTostaffentity(stf));
    }

    @Override
    public void deletestaff(String idvalue) {
    if(!stdao.findById(idvalue).isPresent())
    {
        throw new membernotfoundexception("Staff member not found");
    }
    stdao.deleteById(idvalue);
    }

    @Override
    public void updatestu(String st, staffdto staffd) {
        st = st.trim();
        Optional<staffentity> foundstaff = stdao.findById(st);
        if (!foundstaff.isPresent()) {
            throw new membernotfoundexception("staff member not found");
        }
        staffentity staff = foundstaff.get();
        staff.setName(staffd.getName());
        staff.setMobileno(staffd.getMobileno());
        staff.setEmail(staffd.getEmail());
        staff.setAddress(staffd.getAddress());
        staff.setRole(staffd.getRole());
        // ✅ Parse and set date
        staff.setJoin_date(LocalDate.parse(staffd.getJoin_date()));

        // ✅ Parse and set time
        staff.setJoin_time(Time.valueOf(staffd.getJoin_time())); // must be in HH:mm:ss format

        stdao.save(staff);

    }

    @Override
    public staffdto getstaff(String st) {

        Optional<staffentity> foundstaff =stdao.findById(st);
        if(!foundstaff.isPresent())
        {
            throw new membernotfoundexception(" Selected member not found");
        }
        staffentity selectstaff = stdao.getReferenceById(st);
        staffdto selstadto = entityconvert.convertstaffentityTostaffdto(selectstaff);

        return selstadto;
    }

    @Override
    public List<staffdto> getallstaff() {


        return entityconvert.tostaffDtolist(stdao.findAll());

    }
}
