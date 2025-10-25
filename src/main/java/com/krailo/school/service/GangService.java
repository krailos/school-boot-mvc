package com.krailo.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.GangDto;
import com.krailo.school.entity.Gang;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.GangMapper;
import com.krailo.school.repository.GangRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class GangService {

    private GangRepository gangRepository;
    private GangMapper gangMapper;

    
    public List<GangDto> findAll() {
      return gangRepository.findAll().stream().map(gangMapper::mapEntityToDto).toList();
  }


    public GangDto findById(Integer id) {
        return gangRepository.findById(id).map(gangMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Gang whith id= %d not exist", id)));
    }

    public Gang findByIdEntity(Integer id) {
        return gangRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Audience whith id= %d not exist", id)));
    }

    public GangDto create(GangDto gangDto) {
        return Optional.of(gangDto).map(gangMapper::mapDtoToEntityForCreate).map(gangRepository::save)
                .map(gangMapper::mapEntityToDto).orElseThrow();
    }

    public GangDto update(Integer id, GangDto gangDto) {
        return gangRepository.findById(id)
                .map(entity -> gangMapper.mapDtoToEntityForUpdate(gangDto, entity))
                .map(gangRepository::saveAndFlush).map(gangMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return gangRepository.findById(id).map(entity -> {
            gangRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
