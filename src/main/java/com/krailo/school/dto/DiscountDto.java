package com.krailo.school.dto;

import java.time.LocalDate;

import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.enumeration.DiscountType;

import lombok.Value;

@Value
public class DiscountDto {
    

    private Integer id;
    private DiscountType type;
    private int value;
    private Student student;
    private Integer studentId; 
    private Subject subject;
    private Integer subjectId;
    private LocalDate date;

}
