package com.example.stumanagement.controller;

import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.dto.studto;
import com.example.stumanagement.exception.membernotfoundexception;
import com.example.stumanagement.exception.studentnotfoundexception;
import com.example.stumanagement.service.Staffservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class Staffcontroller {
    private final Staffservice stservice;
    @GetMapping("health")
    public  String healthtest()
    {
        return "staff ok......";

    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> Addstaff(@RequestBody staffdto stf)
    {
        if(stf==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        stservice.Addstaff(stf);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @DeleteMapping
    public ResponseEntity<Void> deletestaff (@RequestParam("staffid") String idvalue)
    {
        idvalue = idvalue.trim();  //
        if(idvalue==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{ stservice.deletestaff(idvalue);
            return  ResponseEntity.noContent().build();}
        catch ( membernotfoundexception e)
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
    public ResponseEntity<Void> updatestu(@RequestParam("st") String st,@RequestBody staffdto staffd)
    {
        if(st==null||staffd==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        stservice.updatestu(st,staffd);

        return  ResponseEntity.noContent().build();

    }
    @GetMapping
    public ResponseEntity<staffdto> getstaff(@RequestParam("st") String st) {
        st = st.trim();
        if(st==null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try{  return ResponseEntity.ok(stservice.getstaff(st));}
        catch (membernotfoundexception e)
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

    @GetMapping(value = "getallsta")
    public ResponseEntity<List<staffdto>> getallstaff () {

        return ResponseEntity.ok(stservice.getallstaff());
    }


}
