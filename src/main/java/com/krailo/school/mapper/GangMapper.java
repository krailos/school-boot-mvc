package com.krailo.school.mapper;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.GangDto;
import com.krailo.school.entity.Gang;
import com.krailo.school.repository.SubjectRepository;
import com.krailo.school.repository.TeacherRepository;

@Component
public class GangMapper implements Mapper<Gang, GangDto> {
    
    SubjectRepository subjectRepository;
    TeacherRepository teacherRepository;

    @Override
    public GangDto mapEntityToDto(Gang o) {
        return new GangDto(o.getId(), o.getName(), o.getDescription(), o.getSubject(), o.getSubject().getId(),
                o.getTeacher(), o.getTeacher().getId(), o.getGangStudents());
    }

    @Override
    public Gang mapDtoToEntityForCreate(GangDto d) {
       Gang e = new Gang();
       e.setName(d.getName());
       e.setDescription(d.getDescription());
       e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
       e.setTeacher(teacherRepository.findById(d.getTeacherId()).get());       
        return null;
    }

    @Override
    public Gang mapDtoToEntityForUpdate(GangDto d, Gang e) {
        e.setId(d.getId());
        e.setName(d.getName());
        e.setDescription(d.getDescription());
        e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
        e.setTeacher(teacherRepository.findById(d.getTeacherId()).get());   
        return null;
    }

}
