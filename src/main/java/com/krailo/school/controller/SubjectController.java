package com.krailo.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.SubjectDto;
import com.krailo.school.entity.Subject;
import com.krailo.school.service.SubjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "/subjects";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("subject", subjectService.findById(id));
        return "/subject";        
    }
    
    
    @GetMapping("/subject/new")
    public String createForm (Model model) {
    model.addAttribute("subject", new Subject());
    return "/subjectNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute SubjectDto subject) {
        subjectService.create(subject);  
        return "redirect:/subjects";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute SubjectDto subject) {
           subjectService.update(id, subject); 
        return "redirect:/subjects";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         subjectService.delete(id); 
        return "redirect:/subjects";        
    }

}
