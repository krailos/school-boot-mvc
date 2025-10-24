package com.krailo.school.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.SubjectDto;
import com.krailo.school.entity.Price;
import com.krailo.school.entity.Subject;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.SubjectMapper;
import com.krailo.school.repository.PriceRepository;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class GangService {

    private SubjectRepository subjectRepository;
    private PriceRepository priceRepository;
    private SubjectMapper subjectMapper;

    
    public List<SubjectDto> findAll() {
      return subjectRepository.findAll().stream().peek(s -> s.getPrices().sort((o1, o2) -> o2.getDate().compareTo(o1.getDate())))
              .map(subjectMapper::mapEntityToDto).toList();
  }


    public SubjectDto findById(Integer id) {
        return subjectRepository.findById(id).map(subjectMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Subject whith id= %d not exist", id)));
    }

    public Subject findByIdEntity(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Audience whith id= %d not exist", id)));
    }

    public SubjectDto create(SubjectDto subjectDto) {
        return Optional.of(subjectDto).map(subjectMapper::mapDtoToEntityForCreate).map(subjectRepository::save)
                .map(subjectMapper::mapEntityToDto).orElseThrow();
    }

    public SubjectDto update(Integer id, SubjectDto subjectDto) {
        return subjectRepository.findById(id)
                .map(entity -> subjectMapper.mapDtoToEntityForUpdate(subjectDto, entity))
                .map(subjectRepository::saveAndFlush).map(subjectMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return subjectRepository.findById(id).map(entity -> {
            subjectRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}
