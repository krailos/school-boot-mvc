package com.krailo.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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

      //  System.out.println(priceService.findBySubject(subjectService.findByIdEntity(1)));
      //  subjectService.findAllWhithSortedByPriceDate().stream().forEach(s ->System.out.println(s.getPrices()));
         System.out.println(subjectService.findAll());



    }

}
