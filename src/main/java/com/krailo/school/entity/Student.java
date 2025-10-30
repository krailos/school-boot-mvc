package com.krailo.school.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.krailo.school.enumeration.Gender;
import com.krailo.school.enumeration.StudentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = {"studentGangs", "studentsDiscounts", "payments", "lessonsStudents"})
@ToString(exclude =  {"studentGangs", "studentsDiscounts", "payments", "lessonsStudents"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<GangsStudents> gangsStudents;
    private String firstName;
    private String secondName;
    private String lastName;
    private String contactName;
    private String phone;
    private String email;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;
    private LocalDate birthDate;
    private String description;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentsDiscounts> studentsDiscounts;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Payment> payments;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<LessonsStudents> lessonsStudents;
    
    
//    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
//    private List<Lesson> lessons;
    


}
