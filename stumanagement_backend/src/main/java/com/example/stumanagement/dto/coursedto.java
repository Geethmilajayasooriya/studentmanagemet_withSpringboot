package com.example.stumanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class coursedto implements Serializable {
    private String courseid;
    private String name;
    private String credit;
    private String semester;
    private Boolean compulsory;
    private String department;
    private String status;
}

