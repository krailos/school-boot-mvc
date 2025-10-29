package com.krailo.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.AudienceDto;
import com.krailo.school.dto.PaymentDto;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.AudienceMapper;
import com.krailo.school.mapper.PaymentMapper;
import com.krailo.school.repository.AudienceRepository;
import com.krailo.school.repository.PaymentRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentMapper  paymentMapper;

    public List<PaymentDto> findAll() {
        return paymentRepository.findAll().stream().map(paymentMapper::mapEntityToDto).toList();
    }

    public PaymentDto findById(Integer id) {
        return paymentRepository.findById(id).map(paymentMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Audience whith id= %d not exist", id)));
    }

    public PaymentDto create(PaymentDto paymentDto) {
        return Optional.of(paymentDto).map(paymentMapper::mapDtoToEntityForCreate).map(paymentRepository::save)
                .map(paymentMapper::mapEntityToDto).orElseThrow();
    }

    public PaymentDto update(Integer id, PaymentDto paymentDto) {
        return paymentRepository.findById(id)
                .map(entity -> paymentMapper.mapDtoToEntityForUpdate(paymentDto, entity))
                .map(paymentRepository::saveAndFlush).map(paymentMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return paymentRepository.findById(id).map(entity -> {
            paymentRepository.delete(entity);
            return true;
        }).orElse(false);
    }

}
