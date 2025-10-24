package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Audience;

public interface AudienceRepository extends JpaRepository<Audience, Integer> {

}
