package com.krailo.school.entity;

import java.time.LocalDate;
import java.util.List;

import com.krailo.school.enumeration.DiscountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@EqualsAndHashCode(exclude = {"studentsDiscounts"})
@ToString(exclude ={"studentsDiscounts"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Discount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "discount_value")
    private int value;
    @Column(name = "discount_date")
    private LocalDate date;
    @OneToMany(mappedBy = "discount")
    private List<StudentsDiscounts> studentsDiscounts;

}
