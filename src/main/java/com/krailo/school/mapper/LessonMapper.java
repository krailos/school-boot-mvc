package com.krailo.school.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.LessonDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.repository.AudienceRepository;
import com.krailo.school.repository.GangRepository;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LessonMapper implements Mapper<Lesson, LessonDto> {
    
    private SubjectRepository subjectRepository;
    private GangRepository gangRepository;
    private AudienceRepository audienceRepository;

    @Override
    public Lesson mapDtoToEntityForCreate(LessonDto d) {
       Lesson e = new Lesson();
        e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
        e.setGang(gangRepository.findById(d.getGangId()).get()); 
        e.setAudience(audienceRepository.findById(d.getAudienceId()).get());
        e.setDate(d.getDate());
        e.setStartTime(d.getStartTime());
        e.setEndTime(d.getEndTime());
        e.setLessonStudents(d.getLessonStudents());
        e.setLessonStudents(d.getLessonStudents());
        return e;
    }

    @Override
    public LessonDto mapEntityToDto(Lesson e) {
        return new LessonDto(
                e.getId(), 
                e.getSubject(), 
                e.getSubject().getId(), 
                e.getGang(),
                e.getGang().getId(),
                e.getAudience(),
                e.getAudience().getId(),
                e.getDate(),
                e.getStartTime(),
                e.getEndTime(),
                e.getLessonStudents());     
    }

    @Override
    public Lesson mapDtoToEntityForUpdate(LessonDto d, Lesson e) {   
        e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
        e.setGang(gangRepository.findById(d.getGangId()).get()); 
        e.setAudience(audienceRepository.findById(d.getAudienceId()).get());
        e.setDate(d.getDate());
        e.setStartTime(d.getStartTime());
        e.setEndTime(d.getEndTime());
        e.setLessonStudents(d.getLessonStudents());
        e.setLessonStudents(d.getLessonStudents());
        return e;
    }

}
