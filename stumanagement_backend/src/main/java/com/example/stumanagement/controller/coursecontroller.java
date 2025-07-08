package com.example.stumanagement.controller;

import com.example.stumanagement.dto.coursedto;
import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.exception.coursenotfoundexception;
import com.example.stumanagement.exception.membernotfoundexception;
import com.example.stumanagement.service.Courseservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class coursecontroller {
    private final Courseservice courses;

    @GetMapping("health")
    public  String healthtest()
    {
        return "course ok......";

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> Addcourse(@RequestBody coursedto cou)
    {
        if(cou==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        courses.Addcourse(cou);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<Void> deletecourse (@RequestParam("courseid") String idvalue)
    {
        idvalue = idvalue.trim();  //
        if(idvalue==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            courses.deletecourse(idvalue);
            return ResponseEntity.noContent().build();
        }
        catch ( coursenotfoundexception e)
        {

            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        catch (Exception e)
        {

            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatecourse(@RequestParam("st") String st,@RequestBody coursedto coursefd)
    {
        if(st==null||coursefd==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        courses.updatecourse(st,coursefd);

        return  ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<coursedto> getcourse(@RequestParam("st") String st) {
        st = st.trim();
        if(st==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {

            return ResponseEntity.ok(courses.getcourse(st));
        }
        catch (coursenotfoundexception e)
        {

            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        catch (Exception e)
        {

            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "getall")
    public ResponseEntity<List<coursedto>> getallcourse () {



        return ResponseEntity.ok(courses.getallcourse());
    }


}
