package com.krailo.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.krailo.school.dto.AudienceDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.service.AudienceService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/audiences")
@RequiredArgsConstructor
public class AudienceController {

    private final AudienceService audienceService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("audiences", audienceService.findAll());
        return "/audiences";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("audience", audienceService.findById(id));
        return "/audience";        
    }
    
    
    @GetMapping("/audience/new")
    public String createForm (Model model) {
    model.addAttribute("audience", new Audience());
    return "/audienceNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute AudienceDto audience) {
        audienceService.create(audience);  
        return "redirect:/audiences";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute AudienceDto audience) {
           audienceService.update(id, audience); 
        return "redirect:/audiences";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         audienceService.delete(id); 
        return "redirect:/audiences";        
    }

}
