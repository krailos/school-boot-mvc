package com.krailo.school.entity;

import java.time.LocalTime;

import com.krailo.school.enumeration.WeekDay;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "audience_id")
    private Audience audience;
    @ManyToOne
    @JoinColumn(name = "gang_id")
    private Gang gang;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Enumerated(EnumType.STRING)
    private WeekDay weekDay;
    private LocalTime startTime;
    private LocalTime endTime;
    
}
