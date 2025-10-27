package com.krailo.school.dto;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Subject;
import com.krailo.school.enumeration.WeekDay;

import lombok.Value;

@Value
public class ScheduleDto {
    
    private int id;
    private Audience audience;
    private Integer audienceId;
    private Gang gang;
    private Integer gangId;
    private Subject subject;
    private Integer subjectId;
    private WeekDay weekDay;
    private LocalTime startTime;
    private LocalTime endTime;

}
