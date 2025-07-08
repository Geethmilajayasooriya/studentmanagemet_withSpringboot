package com.example.stumanagement.entities;

import com.example.stumanagement.dto.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")

public class staffentity {
    @Id
    private String staffid;
    private String name;
    private String address;
    private String mobileno;
    private String email;
    private Role role;

    private Time join_time;
    private LocalDate join_date;
}
