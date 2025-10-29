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
import com.krailo.school.dto.DiscountDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.service.AudienceService;
import com.krailo.school.service.DiscountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("discounts", discountService.findAll());
        return "/discounts";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("discount", discountService.findById(id));
        return "/discount";        
    }
    
    
    @GetMapping("/discount/new")
    public String createForm (Model model) {
    model.addAttribute("audience", new Audience());
    return "/discountNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute DiscountDto discount) {
        discountService.create(discount);  
        return "redirect:/discounts";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute DiscountDto discount) {
           discountService.update(id, discount); 
        return "redirect:/discounts";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         discountService.delete(id); 
        return "redirect:/discounts";        
    }

}
