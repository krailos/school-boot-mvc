package com.krailo.school.dto;

import java.time.LocalDate;

import com.krailo.school.entity.Student;

import lombok.Value;

@Value
public class PaymentDto {


    private Integer id;  
    private Student student;   
    private Integer studentId;   
    private int value;
    private LocalDate date;
    private String description;
    
}
