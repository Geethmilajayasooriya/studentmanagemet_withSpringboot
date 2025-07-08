package com.example.stumanagement.controller;

import com.example.stumanagement.dto.studto;
import com.example.stumanagement.exception.studentnotfoundexception;
import com.example.stumanagement.service.Stuservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class Studentcontroller {
   // private static final Logger logger= LoggerFactory.getLogger(Studentcontroller.class);

    private  final Stuservice stuservice;
    @GetMapping("health")
    public  String healthtest()
    {
        return "student ok......";

    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> Addstu(@RequestBody studto stu)
    {
        if(stu==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        stuservice.Addstu(stu);

return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<Void> deletestu (@RequestParam("stu_id") String idvalue)
    {
        idvalue = idvalue.trim();  //
        if(idvalue==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{  stuservice.deletestu(idvalue);
            return  ResponseEntity.noContent().build();
        }
        catch (studentnotfoundexception e)
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
    public ResponseEntity<Void> updatestu(@RequestParam("st") String st,@RequestBody studto studentd)
    {
        if(st==null||studentd==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        stuservice.updatestu(st,studentd);

        return  ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<studto> getstudet(@RequestParam("st") String st) {
        st = st.trim();
        if(st==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Requested ID: [" + st + "]");
        try{ return ResponseEntity.ok(stuservice.getstudent(st));
        }
        catch (studentnotfoundexception e)
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

        @GetMapping(value = "getallstu")
        public ResponseEntity<List<studto>> getallstu () {


            return ResponseEntity.ok(stuservice.getallstu());
        }


    }


