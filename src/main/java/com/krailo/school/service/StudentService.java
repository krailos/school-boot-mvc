package com.krailo.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.StudentDto;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.StudentMapper;
import com.krailo.school.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class StudentService {
    
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    
    public List<StudentDto> findAll() {
      return studentRepository.findAll().stream().map(studentMapper::mapEntityToDto).toList();
  }


    public StudentDto findById(Integer id) {
        return studentRepository.findById(id).map(studentMapper::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Gang whith id= %d not exist", id)));
    }


    public StudentDto create(StudentDto studentDto) {
        return Optional.of(studentDto).map(studentMapper::mapDtoToEntityForCreate).map(studentRepository::save)
                .map(studentMapper::mapEntityToDto).orElseThrow();
    }

    public StudentDto update(Integer id, StudentDto studentDto) {
        return studentRepository.findById(id)
                .map(entity -> studentMapper.mapDtoToEntityForUpdate(studentDto, entity))
                .map(studentRepository::saveAndFlush).map(studentMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return studentRepository.findById(id).map(entity -> {
            studentRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}