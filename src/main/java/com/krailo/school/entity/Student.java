package com.krailo.school.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.krailo.school.enumeration.Gender;
import com.krailo.school.enumeration.StudentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "gang")
@ToString(exclude = "gang")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="gang_id")
    private Gang gang;
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
    @OneToMany(mappedBy = "student")
    private List<Discount> discounts;


}
