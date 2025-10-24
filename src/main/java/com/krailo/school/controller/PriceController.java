package com.krailo.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.PriceDto;
import com.krailo.school.dto.SubjectDto;
import com.krailo.school.entity.Price;
import com.krailo.school.entity.Subject;
import com.krailo.school.mapper.SubjectMapper;
import com.krailo.school.service.PriceService;
import com.krailo.school.service.SubjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PriceController {

    private final PriceService priceService;
    private final SubjectService subjectService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("prices", priceService.findAll());
        return "/prices";
    }
    
    @GetMapping("/{id}/bysubject")
    public String findBySubject( @PathVariable("id") Integer id, Model model) {
        Subject subject = subjectService.findByIdEntity(id);
        model.addAttribute("prices", priceService.findBySubject(subject));
        model.addAttribute("subject", subjectService.findById(id));
        return "/prices";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          PriceDto priceDto =  priceService.findById(id);
          model.addAttribute("price", priceDto);
          model.addAttribute("subject", subjectService.findById(priceDto.getSubjectId()));
        return "/price";        
    }
    
    
    @GetMapping("/price/new")
    public String createForm (Model model) {
    model.addAttribute("subjects", subjectService.findAll());
    return "/priceNew";
    }
    
    @GetMapping("/price/new/{id}")
    public String createFormWhithChackedSubject (@PathVariable("id") Integer priceId, Model model) {
    model.addAttribute("subjects", subjectService.findAll());
    model.addAttribute("subjectChoosen", subjectService.findById(priceId));
    return "/priceNew";
    }
    
    
    @PostMapping("/create")
    public String create ( @ModelAttribute PriceDto priceDto) {
        System.out.println(priceDto);
        priceService.create(priceDto);  
        return "redirect:/prices";     
    }
    
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute PriceDto price) {
        System.out.println(price);
           priceService.update(id, price); 
        return "redirect:/prices";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         priceService.delete(id); 
        return "redirect:/prices";        
    }

}
