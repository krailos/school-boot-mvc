package com.krailo.school.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Student;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    
    @Query("""
            SELECT l from Lesson l 
            JOIN FETCH l.lessonsStudents ls
            WHERE ls.student = :student 
            AND l.date BETWEEN :start AND :end
            """)
    List<Lesson> findAllByStudentAndBetweenDates (Student student, LocalDate start, LocalDate end);
      

}
