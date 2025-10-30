package com.krailo.school.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.DiscountDto;
import com.krailo.school.dto.LessonDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Discount;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.repository.AudienceRepository;
import com.krailo.school.repository.GangRepository;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DiscountMapper implements Mapper<Discount, DiscountDto> {
    
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;


    @Override
    public Discount mapDtoToEntityForCreate(DiscountDto d) {
       Discount e = new Discount();
        e.setName(d.getName());
        e.setValue(d.getValue());
        e.setDate(d.getDate());
        e.setStudentsDiscounts(d.getStudentsDiscounts());
        return e;
    }

    @Override
    public DiscountDto mapEntityToDto(Discount e) {
        return new DiscountDto(
                e.getId(), 
                e.getName(),
                e.getValue(),
                e.getDate(),
                e.getStudentsDiscounts()
                );
    }

    @Override
    public Discount mapDtoToEntityForUpdate(DiscountDto d, Discount e) {   
        e.setName(d.getName());
        e.setValue(d.getValue());
        e.setDate(d.getDate());
        e.setStudentsDiscounts(d.getStudentsDiscounts());
        return e;
    }

}
