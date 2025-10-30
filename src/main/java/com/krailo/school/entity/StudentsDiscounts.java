package com.krailo.school.entity;

import java.time.LocalDate;
import java.util.List;

import com.krailo.school.enumeration.DiscountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@EqualsAndHashCode(exclude = {"discount", "student", "subject"})
@ToString(exclude = {"discount", "student", "subject"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students_discounts")
public class StudentsDiscounts {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column(name = "students_discounts_date")
    private LocalDate date;


}
