package com.krailo.school;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Student;
import com.krailo.school.repository.LessonRepository;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.repository.SubjectRepository;
import com.krailo.school.service.AudienceService;
import com.krailo.school.service.LessonService;
import com.krailo.school.service.PriceService;
import com.krailo.school.service.ScheduleService;
import com.krailo.school.service.StudentService;
import com.krailo.school.service.SubjectService;
import com.krailo.school.view.AppView;

@SpringBootApplication
public class SchoolBootMvcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SchoolBootMvcApplication.class, args);

        AppView appView = context.getBean(AppView.class);

        SubjectService subjectService = context.getBean(SubjectService.class);
        ScheduleService scheduleService = context.getBean(ScheduleService.class);
        PriceService priceService = context.getBean(PriceService.class);
        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        StudentService studentService = context.getBean(StudentService.class);
        LessonService lessonService = context.getBean(LessonService.class);
        LessonRepository lessonRepository = context.getBean(LessonRepository.class);

      //  System.out.println(priceService.findBySubject(subjectService.findByIdEntity(1)));
      //  subjectService.findAllWhithSortedByPriceDate().stream().forEach(s ->System.out.println(s.getPrices()));
        Student sudent = studentRepository.findById(1).get();
         List<Lesson> lessons = lessonRepository.findAllByStudentAndBetweenDates(sudent, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30));
         for (Lesson lesson : lessons) {
            System.out.println(lesson);
        }
        Lesson lesson = lessons.get(0);
        System.out.println(lesson.getSubject().getName());
        System.out.println(lesson.getGang().getName());
        System.out.println(lesson.getLessonsStudents().get(0).isPresent());
        System.out.println(lesson.getLessonsStudents().get(0).isPayed());



    }

}
