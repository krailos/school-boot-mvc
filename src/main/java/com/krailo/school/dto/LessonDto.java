package com.krailo.school.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Gang;
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
    private List<Student> students;
    
//    public LessonDto(int id, Subject subject, Integer subject_id, Gang gang, Integer gang_id, Audience audience,
//            Integer audience_id, LocalDate lessonDate, LocalTime startTime, LocalTime endTime, List<Student> students) {
//        this.id = id;
//        this.subject = subject;
//        this.subject_id = subject_id;
//        this.gang = gang;
//        this.gang_id = gang_id;
//        this.audience = audience;
//        this.audience_id = audience_id;
//        this.lessonDate = lessonDate;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.students = students;
//    }
    


}
