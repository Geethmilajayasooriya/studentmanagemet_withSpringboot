package com.example.stumanagement.dao;

import com.example.stumanagement.entities.studententity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentdao extends JpaRepository<studententity,String> {

}
