package com.krailo.school.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.GangDto;
import com.krailo.school.dto.LessonDto;
import com.krailo.school.dto.ScheduleDto;
import com.krailo.school.dto.StudentDto;
import com.krailo.school.dto.SubjectDto;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.GangsStudents;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.mapper.LessonMapper;
import com.krailo.school.repository.LessonRepository;
import com.krailo.school.repository.LessonsStudentsRepository;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.service.GangService;
import com.krailo.school.service.LessonService;
import com.krailo.school.service.ScheduleService;
import com.krailo.school.service.StudentService;
import com.krailo.school.service.SubjectService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/schedules")
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;
    private StudentService studentService;
    private GangService gangService;
    private LessonMapper lessonMapper;
    private LessonService lessonService;
    private LessonsStudentsRepository lessonsStudentsRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("schedules", scheduleService.findAll());
        return "/schedules";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("schedule", scheduleService.findById(id));
        return "/schedule";
    }

    @GetMapping("/schedule/new")
    public String createForm(Model model) {
        model.addAttribute("gang", new Subject());
        return "/scheduleNew";
    }

    @PostMapping("/create")
    // @ResponseStatus(HttpStatus.CREATED)
    public String create(@ModelAttribute ScheduleDto scheduleDto) {
        scheduleService.create(scheduleDto);
        return "redirect:/schedules";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Integer id, @ModelAttribute ScheduleDto scheduleDto) {
        scheduleService.update(id, scheduleDto);
        return "redirect:/schedules";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Integer id) {
        scheduleService.delete(id);
        return "redirect:/schedules";
    }

    @PostMapping("/{id}/lesson")
    public String makeLesson(@PathVariable("id") Integer id, Model model) {
        Lesson lesson = new Lesson();

        ScheduleDto scheduleDto = scheduleService.findById(id);
        lesson.setAudience(scheduleDto.getAudience());
        lesson.setSubject(scheduleDto.getSubject());
        lesson.setGang(scheduleDto.getGang());
        lesson.setStartTime(scheduleDto.getStartTime());
        lesson.setEndTime(scheduleDto.getEndTime());

        List<Student> students = new ArrayList<Student>();
        for (GangsStudents gs : scheduleDto.getGang().getGangStudents()) {
            students.add(gs.getStudent());
        }
        List<LessonsStudents> ls = new ArrayList<LessonsStudents>();
        for (Student student : students) {
            LessonsStudents lessonStudent = new LessonsStudents();
            lessonStudent.setStudent(student);
            ls.add(lessonStudent);
        }
        lesson.setLessonStudents(ls);
        model.addAttribute("lesson", lesson);
        return "/lessonNew";
    }

    @PostMapping("/lessons/create")
    public String testCreate(@ModelAttribute LessonDto lessonDto) {
        System.out.println(lessonDto.getLessonStudents());
        LessonDto lessonDtoWhithId = lessonService.create(lessonDto);
        System.out.println(lessonDto);    
        Lesson lesson = lessonService.findByIdEntity(lessonDtoWhithId.getId());
        List<LessonsStudents> ls = lessonDto.getLessonStudents();
        for (LessonsStudents lessonsStudents : ls) {
            lessonsStudents.setLesson(lesson);
            lessonsStudentsRepository.save(lessonsStudents);
        }
        return "redirect:/lessons";
    }

}

