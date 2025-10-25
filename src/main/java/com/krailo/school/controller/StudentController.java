package com.krailo.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.GangDto;
import com.krailo.school.dto.SubjectDto;
import com.krailo.school.entity.GangsStudents;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;
import com.krailo.school.repository.StudentRepository;
import com.krailo.school.service.GangService;
import com.krailo.school.service.SubjectService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private GangService gangService;
    private StudentRepository studentRepository;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("gangs", gangService.findAll());
        return "/students";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("gang", gangService.findById(id));
        return "/student";        
    }
    
    
    
    @GetMapping("/student/new")
    public String createForm (Model model) {
    model.addAttribute("gang", new Subject());
    return "/studentNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute GangDto gang) {
        gangService.create(gang);  
        return "redirect:/students";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute GangDto gangDto) {
           gangService.update(id, gangDto); 
        return "redirect:/students";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         gangService.delete(id); 
        return "redirect:/students";        
    }

}
