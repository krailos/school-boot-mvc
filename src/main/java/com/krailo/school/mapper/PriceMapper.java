package com.krailo.school.mapper;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.PriceDto;
import com.krailo.school.entity.Price;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.repository.SubjectRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component
@AllArgsConstructor
public class PriceMapper implements Mapper<Price, PriceDto> {

    SubjectRepository subjectRepository;

    @Override
    public PriceDto mapEntityToDto(Price entity) {

        return new PriceDto(entity.getId(), entity.getName(), entity.getValue(), entity.getDate(),
                entity.getSubject().getId(), entity.getSubject());
    }

    @Override
    public Price mapDtoToEntityForCreate(PriceDto dto) {
        Price entity = new Price();
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDate(dto.getDate());
        entity.setSubject(subjectRepository.findById(dto.getSubjectId()).orElseThrow(() -> new EntityNotFoundException(
                String.format("Subject whith id= %d not exist", dto.getSubjectId()))));
        return entity;
    }

    @Override
    public Price mapDtoToEntityForUpdate(PriceDto dto, Price entity) {
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDate(dto.getDate());
        entity.setSubject(subjectRepository.findById(dto.getSubjectId()).orElseThrow(() -> new EntityNotFoundException(
                String.format("Subject whith id= %d not exist", dto.getSubjectId()))));
        return entity;
    }

}
