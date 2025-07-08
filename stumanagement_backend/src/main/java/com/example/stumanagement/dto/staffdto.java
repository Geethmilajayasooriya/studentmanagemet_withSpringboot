package com.example.stumanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class staffdto implements Serializable {
    private String staffid;
    private String name;
    private String address;
    private String mobileno;
    private String email;
    private Role role;

    private String join_time;
    private String join_date;
}
