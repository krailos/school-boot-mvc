package com.krailo.school.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;

import lombok.Value;

@Value
public class LessonDto {    
    
    private Integer id;
    private Subject subject;
    private Integer subjectId;
    private Gang gang;
    private Integer gangId;
    private Audience audience;
    private Integer audienceId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<LessonsStudents> lessonStudents;
//    private List<Student> students;

    


}
