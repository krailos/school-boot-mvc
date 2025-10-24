package com.krailo.school.dto;

import java.util.List;

import com.krailo.school.entity.Price;

import lombok.Value;

@Value
public class SubjectDto {
    
    private Integer id;
    private String name;
    private String description;
    private List<Price> prices;

}
