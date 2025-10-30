package com.krailo.school.dto;

import java.time.LocalDate;
import java.util.List;

import com.krailo.school.entity.Discount;
import com.krailo.school.entity.GangsStudents;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.entity.Payment;
import com.krailo.school.entity.StudentsDiscounts;
import com.krailo.school.enumeration.Gender;
import com.krailo.school.enumeration.StudentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Value;

@Value
public class StudentDto {
 
    private Integer id;
    private List<GangsStudents> gangsStudents;
    private String firstName;
    private String secondName;
    private String lastName;
    private String contactName;
    private String phone;
    private String email;
    private String address;
    private Gender gender;
    private StudentStatus studentStatus;
    private LocalDate birthDate;
    private String description;
    private List<StudentsDiscounts> studentsDiscounts;
    private List<Payment> payments;
    private List<LessonsStudents> lessonsStudents;

}
