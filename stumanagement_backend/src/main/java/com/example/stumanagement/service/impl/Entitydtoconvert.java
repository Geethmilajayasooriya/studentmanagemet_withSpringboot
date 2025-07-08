package com.example.stumanagement.service.impl;

import com.example.stumanagement.dto.studto;
import com.example.stumanagement.entities.studententity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;

@Component
public class Entitydtoconvert {

    // Convert DTO to Entity
    public studententity convertstudtoToSTENTITY(studto dto) {
        studententity entity = new studententity();
        entity.setStu_id(dto.getStu_id());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setMobileno(dto.getMobileno());
        entity.setEmail(dto.getEmail());
        entity.setGender(dto.getGender());
        entity.setDepartment(dto.getDepartment());
        entity.setStatus(dto.getStatus());

        // Optional: parse string to LocalDate if format is suitable, or store current date as fallback


        return entity;
    }
    public List<studto> TOstudentdto(List<studententity> entities) {
        return entities.stream()
                .map(this::convertSTENTITYToDTO)
                .collect(Collectors.toList());
    }

    // Convert Entity to DTO
    public studto convertSTENTITYToDTO(studententity entity) {
        return new studto(
                entity.getStu_id(),
                entity.getName(),
                entity.getAddress(),
                entity.getMobileno(),
                entity.getEmail(),
                entity.getGender(),
                entity.getDepartment(),
                entity.getStatus()// Convert LocalDate to String
        );
    }
}

