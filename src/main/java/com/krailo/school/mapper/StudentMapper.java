package com.krailo.school.mapper;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.StudentDto;
import com.krailo.school.entity.Student;

@Component
public class StudentMapper implements Mapper<Student, StudentDto> {

    @Override
    public Student mapDtoToEntityForCreate(StudentDto d) {
        Student e = new Student();
        e.setStudentGangs(d.getStudentGangs());
        e.setFirstName(d.getFirstName());
        e.setSecondName(d.getSecondName());
        e.setLastName(d.getLastName());
        e.setContactName(d.getContactName());
        e.setPhone(d.getPhone());
        e.setEmail(d.getEmail());
        e.setAddress(d.getAddress());
        e.setGender(d.getGender());
        e.setStudentStatus(d.getStudentStatus());
        e.setBirthDate(d.getBirthDate()); 
        e.setDescription(d.getDescription());
        e.setDiscounts(d.getDiscounts());       
        return e;
    }

    @Override
    public StudentDto mapEntityToDto(Student e) {
        return new StudentDto(e.getId(), e.getStudentGangs(), e.getFirstName(), e.getSecondName(), e.getLastName(),
                e.getContactName(), e.getPhone(), e.getEmail(), e.getAddress(), e.getGender(), e.getStudentStatus(),
                e.getBirthDate(), e.getDescription(), e.getDiscounts());
    }

    @Override
    public Student mapDtoToEntityForUpdate(StudentDto d, Student e) {
        e.setStudentGangs(d.getStudentGangs());
        e.setFirstName(d.getFirstName());
        e.setSecondName(d.getSecondName());
        e.setLastName(d.getLastName());
        e.setContactName(d.getContactName());
        e.setPhone(d.getPhone());
        e.setEmail(d.getEmail());
        e.setAddress(d.getAddress());
        e.setGender(d.getGender());
        e.setStudentStatus(d.getStudentStatus());
        e.setBirthDate(d.getBirthDate()); 
        e.setDescription(d.getDescription());
        e.setDiscounts(d.getDiscounts());
        return e;
    }

}
