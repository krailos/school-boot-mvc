package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.LessonsStudents;

public interface LessonsStudentsRepository extends JpaRepository<LessonsStudents, Integer> {

}
