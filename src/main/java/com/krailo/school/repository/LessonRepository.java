package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
