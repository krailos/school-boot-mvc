package com.krailo.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.StudentsDiscountsDto;
import com.krailo.school.service.DiscountService;
import com.krailo.school.service.StudentService;
import com.krailo.school.service.StudentsDiscountsService;
import com.krailo.school.service.SubjectService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/studentsDiscounts")
@AllArgsConstructor
public class StudentsDiscountsController {

    private StudentsDiscountsService studentsDiscountsService;
    private StudentService studentService;
    private DiscountService discountService;
    private SubjectService subjectService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("studentsDiscounts", studentsDiscountsService.findAll());
        return "/studentsDiscounts";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("studentDiscount", studentsDiscountsService.findById(id));
          model.addAttribute("students", studentService.findAll());
          model.addAttribute("discounts", discountService.findAll());
          model.addAttribute("subjects", subjectService.findAll());
        return "/studentDiscount";        
    }
    
    
    @GetMapping("/studentDiscount/new")
    public String createForm (Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("discounts", discountService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
    return "/studentsDiscountsNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute StudentsDiscountsDto studentsDiscountsDto) {
        System.out.println(studentsDiscountsDto.getStudentId());
        System.out.println(studentsDiscountsDto.getDiscountId());
        System.out.println(studentsDiscountsDto.getSubjectId());
        studentsDiscountsService.create(studentsDiscountsDto);  
        return "redirect:/studentsDiscounts";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute StudentsDiscountsDto studentsDiscountsDto) {
        System.out.println(studentsDiscountsDto.getStudentId());
        System.out.println(studentsDiscountsDto.getDiscountId());
        System.out.println(studentsDiscountsDto.getSubjectId());
           studentsDiscountsService.update(id, studentsDiscountsDto); 
        return "redirect:/studentsDiscounts";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         studentsDiscountsService.delete(id); 
        return "redirect:/studentsDiscounts";        
    }

}
