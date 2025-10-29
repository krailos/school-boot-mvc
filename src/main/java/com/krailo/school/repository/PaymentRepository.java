package com.krailo.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
