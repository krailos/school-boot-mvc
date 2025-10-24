package com.krailo.school.dto;

import java.time.LocalDate;

import com.krailo.school.entity.Subject;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
public class PriceDto {
    
    private Integer id;
    private String name;
    private int value;
    private LocalDate date;
    private Integer subjectId;
    private Subject subject;

}
