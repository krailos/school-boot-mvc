package com.krailo.school.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.DiscountDto;
import com.krailo.school.dto.LessonDto;
import com.krailo.school.dto.PaymentDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Discount;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Payment;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.repository.AudienceRepository;
import com.krailo.school.repository.GangRepository;
import com.krailo.school.repository.PaymentRepository;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PaymentMapper implements Mapper<Payment, PaymentDto> {
    
    private PaymentRepository paymentRepository;
    private StudentRepository studentRepository;


    @Override
    public Payment mapDtoToEntityForCreate(PaymentDto d) {
        Payment e = new Payment();      
        e.setStudent(studentRepository.findById(d.getStudentId()).get());
        e.setValue(d.getValue());
        e.setDate(d.getDate());
        e.setDescription(d.getDescription());
        return e;
    }

    @Override
    public PaymentDto mapEntityToDto(Payment e) {
        return new PaymentDto(
                e.getId(),                            
                e.getStudent(), 
                e.getStudent().getId(), 
                e.getValue(),
                e.getDate(),  
                e.getDescription());
    }

    @Override
    public Payment mapDtoToEntityForUpdate(PaymentDto d, Payment e) {   
        e.setStudent(studentRepository.findById(d.getStudentId()).get());
        e.setValue(d.getValue());
        e.setDate(d.getDate());
        e.setDescription(d.getDescription());
        return e;
    }

}
