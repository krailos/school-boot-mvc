package com.krailo.school.mapper;

import org.springframework.stereotype.Component;

import com.krailo.school.dto.AudienceDto;
import com.krailo.school.entity.Audience;

@Component
public class AudienceMapper implements Mapper<Audience, AudienceDto> {

    @Override
    public AudienceDto mapEntityToDto(Audience entity) {

        return new AudienceDto(entity.getId(), entity.getName(), entity.getDescription());
    }

    @Override
    public Audience mapDtoToEntityForCreate(AudienceDto dto) {
        Audience audience = new Audience();
        audience.setName(dto.getName());
        audience.setDescription(dto.getDescription());
        return audience;
    }

    @Override
    public Audience mapDtoToEntityForUpdate(AudienceDto dto, Audience entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
