package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Subject;


public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
