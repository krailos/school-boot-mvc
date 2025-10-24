package com.krailo.school.dto;

import java.util.List;

import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.entity.Teacher;

import lombok.Value;

@Value
public class GangDto {
    
    private Integer id;
    private String name;
    private String description;
    private Subject subject;
    private Integer subjectId;
    private Teacher teacher;
    private Integer teacherId;
    private List<Student> students;

}
