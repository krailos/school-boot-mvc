package com.krailo.school.mapper;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.StudentsDiscountsDto;
import com.krailo.school.entity.Discount;
import com.krailo.school.entity.StudentsDiscounts;
import com.krailo.school.repository.DiscountRepository;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class StudentsDiscountsMapper implements Mapper<StudentsDiscounts, StudentsDiscountsDto> {
    
    DiscountRepository discountRepository;
    StudentRepository studentRepository;
    SubjectRepository subjectRepository;

    @Override
    public StudentsDiscounts mapDtoToEntityForCreate(StudentsDiscountsDto d) {
        StudentsDiscounts e = new StudentsDiscounts();
        e.setId(d.getId());
        e.setDiscount(discountRepository.findById(d.getDiscountId()).get());
        e.setStudent(studentRepository.findById(d.getStudentId()).get());
        e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
        e.setDate(d.getDate());
        return e;
    }

    @Override
    public StudentsDiscountsDto mapEntityToDto(StudentsDiscounts e) {
        return new StudentsDiscountsDto(
                e.getId(),
                e.getDiscount(),
                e.getDiscount().getId(),
                e.getStudent(),
                e.getStudent().getId(), 
                e.getSubject(), 
                e.getSubject().getId(),
                e.getDate());
    }

    @Override
    public StudentsDiscounts mapDtoToEntityForUpdate(StudentsDiscountsDto d, StudentsDiscounts e) {
        e.setId(d.getId());
        e.setDiscount(discountRepository.findById(d.getDiscountId()).get());
        e.setStudent(studentRepository.findById(d.getStudentId()).get());
        e.setSubject(subjectRepository.findById(d.getSubjectId()).get());
        e.setDate(d.getDate());
        return e;
    }

}
