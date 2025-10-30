package com.krailo.school.dto;

import java.time.LocalDate;

import com.krailo.school.entity.Discount;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;

import lombok.Value;

@Value
public class StudentsDiscountsDto {

    private Integer id;
    private Discount discount;
    private Integer discountId;
    private Student student;
    private Integer studentId;
    private Subject subject;
    private Integer subjectId;
    private LocalDate date;
}
