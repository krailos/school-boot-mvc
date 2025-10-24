package com.krailo.school.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
