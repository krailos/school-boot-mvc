package com.krailo.school.entity;

import java.time.LocalDate;

import com.krailo.school.enumeration.DiscountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(exclude = {"student"})
@ToString(exclude ={"student"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Payment {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_id")
    private Student student;
    @Column(name = "payment_value")
    private int value;
    @Column(name = "payment_date")
    private LocalDate date;
    private String description;


}
