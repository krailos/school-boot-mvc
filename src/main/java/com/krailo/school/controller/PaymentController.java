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
import com.krailo.school.dto.PaymentDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.service.AudienceService;
import com.krailo.school.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("payments", paymentService.findAll());
        return "/payments";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("payment", paymentService.findById(id));
        return "/payment";        
    }
    
    
    @GetMapping("/payment/new")
    public String createForm (Model model) {
    model.addAttribute("payment", new Audience());
    return "/paymentsNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute PaymentDto payment) {
        paymentService.create(payment);  
        return "redirect:/payments";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute PaymentDto payment) {
           paymentService.update(id, payment); 
        return "redirect:/payments";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         paymentService.delete(id); 
        return "redirect:/payments";        
    }

}
