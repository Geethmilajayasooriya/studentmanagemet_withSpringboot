package com.example.stumanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student")
public class studententity {
    @Id
    private String stu_id;
    private String name;
    private String address;
    private String mobileno;
    private String email;
    private String gender;

    private String department;
    private String  status;
}
