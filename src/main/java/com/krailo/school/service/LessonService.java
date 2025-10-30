package com.krailo.school.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.krailo.school.dto.LessonDto;
import com.krailo.school.dto.StudentDto;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.exception.EntityNotFoundException;
import com.krailo.school.mapper.LessonMapper;
import com.krailo.school.mapper.StudentMapper;
import com.krailo.school.repository.LessonRepository;
import com.krailo.school.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Transactional
@Service
@AllArgsConstructor
public class LessonService {

    private LessonRepository lessonRepository;
    private LessonMapper lessonMapper;

    public List<LessonDto> findAll() {
        return lessonRepository.findAll().stream()
                .peek(l -> l.getLessonsStudents()
                        .sort((o1, o2) -> o1.getStudent().getLastName().compareTo(o2.getStudent().getLastName())))
                .map(lessonMapper::mapEntityToDto).toList();
    }

//    public List<LessonDto> findAllByStudentPresent() {
//        List<Lesson> lessons = lessonRepository.findAll();
//        for (Lesson lesson : lessons) {
//            List<LessonsStudents> lessonsStudents = lesson.getLessonStudents().stream()
//                    .filter(ls -> ls.isStudentPresent() == true).collect(Collectors.toList());
//            lesson.setLessonStudents(lessonsStudents);
//            System.out.println(lesson.getLessonStudents().size());
//        }
//        return lessons.stream().map(lessonMapper::mapEntityToDto).toList();
//    }

    public LessonDto findById(Integer id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lesson.getLessonsStudents()
                .sort((o1, o2) -> o1.getStudent().getLastName().compareTo(o2.getStudent().getLastName()));
        LessonDto lessonDto = lessonMapper.mapEntityToDto(lesson);
        return lessonDto;
//        return lessonRepository.findById(id).map(lessonMapper::mapEntityToDto)
//                .orElseThrow(() -> new EntityNotFoundException(String.format("Lessson whith id= %d not exist", id)));
    }

    public Lesson findByIdEntity(Integer id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Lessson whith id= %d not exist", id)));
    }

    public LessonDto create(LessonDto lessonDto) {
        return Optional.of(lessonDto).map(lessonMapper::mapDtoToEntityForCreate).map(lessonRepository::save)
                .map(lessonMapper::mapEntityToDto).orElseThrow();
    }

    public LessonDto update(Integer id, LessonDto lessonDto) {
        return lessonRepository.findById(id).map(entity -> lessonMapper.mapDtoToEntityForUpdate(lessonDto, entity))
                .map(lessonRepository::saveAndFlush).map(lessonMapper::mapEntityToDto)
                .orElseThrow(() -> new RuntimeException("smth wrong when update"));
    }

    public boolean delete(Integer id) {
        return lessonRepository.findById(id).map(entity -> {
            lessonRepository.delete(entity);
            return true;
        }).orElse(false);
    }
}