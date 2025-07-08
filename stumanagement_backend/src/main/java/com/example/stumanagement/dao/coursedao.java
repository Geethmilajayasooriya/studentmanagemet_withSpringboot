package com.example.stumanagement.dao;

import com.example.stumanagement.entities.courseentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface coursedao extends JpaRepository<courseentity,String> {

}
