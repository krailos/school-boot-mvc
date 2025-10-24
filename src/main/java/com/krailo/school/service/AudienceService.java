package com.krailo.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.AudienceDto;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.AudienceMapper;
import com.krailo.school.repository.AudienceRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class AudienceService {

    private AudienceRepository audienceRepository;
    private AudienceMapper audienceMapper;

    public List<AudienceDto> findAll() {
        return audienceRepository.findAll().stream().map(audienceMapper::mapEntityToDto).toList();
    }

    public AudienceDto findById(Integer id) {
        return audienceRepository.findById(id).map(audienceMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Audience whith id= %d not exist", id)));
    }

    public AudienceDto create(AudienceDto audienceDto) {
        return Optional.of(audienceDto).map(audienceMapper::mapDtoToEntityForCreate).map(audienceRepository::save)
                .map(audienceMapper::mapEntityToDto).orElseThrow();
    }

    public AudienceDto update(Integer id, AudienceDto audienceDto) {
        return audienceRepository.findById(id)
                .map(entity -> audienceMapper.mapDtoToEntityForUpdate(audienceDto, entity))
                .map(audienceRepository::saveAndFlush).map(audienceMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return audienceRepository.findById(id).map(entity -> {
            audienceRepository.delete(entity);
            return true;
        }).orElse(false);
    }

}
