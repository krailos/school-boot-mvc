package com.krailo.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.GangDto;
import com.krailo.school.dto.ScheduleDto;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Schedule;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.GangMapper;
import com.krailo.school.mapper.ScheduleMapper;
import com.krailo.school.repository.GangRepository;
import com.krailo.school.repository.ScheduleRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ScheduleMapper scheduleMapper;

    
    public List<ScheduleDto> findAll() {
      return scheduleRepository.findAll().stream().map(scheduleMapper::mapEntityToDto).toList();
  }


    public ScheduleDto findById(Integer id) {
        return scheduleRepository.findById(id).map(scheduleMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Gang whith id= %d not exist", id)));
    }

    public Schedule findByIdEntity(Integer id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Audience whith id= %d not exist", id)));
    }

    public ScheduleDto create(ScheduleDto scheduleDto) {
        return Optional.of(scheduleDto).map(scheduleMapper::mapDtoToEntityForCreate).map(scheduleRepository::save)
                .map(scheduleMapper::mapEntityToDto).orElseThrow();
    }

    public ScheduleDto update(Integer id, ScheduleDto scheduleDto) {
        return scheduleRepository.findById(id)
                .map(entity -> scheduleMapper.mapDtoToEntityForUpdate(scheduleDto, entity))
                .map(scheduleRepository::saveAndFlush).map(scheduleMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return scheduleRepository.findById(id).map(entity -> {
            scheduleRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
