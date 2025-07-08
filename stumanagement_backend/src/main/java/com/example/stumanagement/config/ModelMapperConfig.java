package com.example.stumanagement.config;

import com.example.stumanagement.dto.staffdto;
import com.example.stumanagement.entities.staffentity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> stringToLocalDate = ctx -> {
            if (ctx.getSource() == null || ctx.getSource().isBlank()) return null;
            return LocalDate.parse(ctx.getSource(), DateTimeFormatter.ISO_LOCAL_DATE);
        };

        modelMapper.typeMap(staffdto.class, staffentity.class).addMappings(mapper -> {
            mapper.using(stringToLocalDate).map(staffdto::getJoin_date, staffentity::setJoin_date);
        });

        return modelMapper;
    }
}