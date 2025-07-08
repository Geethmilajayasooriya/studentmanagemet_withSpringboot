package com.example.stumanagement.dao;

import com.example.stumanagement.entities.staffentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface staffdao extends JpaRepository<staffentity,String> {

}
