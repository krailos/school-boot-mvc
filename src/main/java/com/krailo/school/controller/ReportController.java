package com.krailo.school.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.AudienceDto;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.Student;
import com.krailo.school.report.ItemBill;
import com.krailo.school.report.Report;
import com.krailo.school.service.LessonService;
import com.krailo.school.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/reports")
@AllArgsConstructor
public class ReportController {

    private  LessonService lessonService;
    private  StudentService studentService;
    private  Report report;
 

    
    @GetMapping()
    public String findAll () {

        return "/reports";        
    }
    
    @GetMapping("/account")
    public String showAccount(Model model) {
        Student student = studentService.findByIdEntity(1);
        List<Lesson> lessons = lessonService.findAllByStudentAndBetweenDatesEntity(student, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 30));
        Lesson lesson = lessons.get(0);
        System.out.println(lesson.getSubject().getName());
        System.out.println(lesson.getSubject().getPrices().get(0).getName());
        System.out.println(lesson.getGang().getName());
        System.out.println(lesson.getLessonsStudents().get(0).isPresent());
        System.out.println(lesson.getLessonsStudents().get(0).isPayed());
        System.out.println(student.getStudentsDiscounts().get(0).getDiscount().getName());
        
        ItemBill itemBill = report.createItem(lesson, student, student.getStudentsDiscounts() );
        System.out.println(itemBill.getDiscount().getValue());
        System.out.println(itemBill.getPrice().getValue());
        
        
        model.addAttribute("audiences", lessonService.findAll());
        return "/lessons";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("audience", lessonService.findById(id));
        return "/audience";        
    }
    

    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute AudienceDto audience) {
      
        return "redirect:/audiences";     
    }

}
