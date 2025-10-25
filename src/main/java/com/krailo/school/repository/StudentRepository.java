package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
