package com.example.stumanagement.util;

import com.example.stumanagement.dto.coursedto;
import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.entities.courseentity;
import com.example.stumanagement.entities.staffentity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Entconvert {
    private final ModelMapper  modelMapper;
    //staff
    public staffentity convertDtoTostaffentity (staffdto stdto)
    {
        return modelMapper.map(stdto,staffentity.class);
    }

    public staffdto convertstaffentityTostaffdto (staffentity stentity)
    {
        return modelMapper.map(stentity,staffdto.class);
    }

    public List<staffdto> tostaffDtolist(List<staffentity> staffentitylist)
    {
        return modelMapper.map(staffentitylist,new TypeToken<List<staffdto>>(){}.getType());
    }

    //course
    public courseentity convertDtoTocourseentity(coursedto coudto)
    {
        return modelMapper.map(coudto,courseentity.class);
    }
    public coursedto convertcourseentityTocoursedto (courseentity coentity)
    {
        return modelMapper.map(coentity,coursedto.class);
    }

    public List<coursedto> tocourseDtolist(List<courseentity> courseentitylist)
    {
        return modelMapper.map(courseentitylist,new TypeToken<List<coursedto>>(){}.getType());
    }
}
