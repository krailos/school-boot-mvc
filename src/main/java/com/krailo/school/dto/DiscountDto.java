package com.krailo.school.dto;

import java.time.LocalDate;
import java.util.List;

import com.krailo.school.entity.Student;
import com.krailo.school.entity.StudentsDiscounts;
import com.krailo.school.entity.Subject;
import com.krailo.school.enumeration.DiscountType;

import lombok.Value;

@Value
public class DiscountDto {
    

    private Integer id;
    private String name;
    private int value;
    private LocalDate date;
    private List<StudentsDiscounts> studentsDiscounts;

}
