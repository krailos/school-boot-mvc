package com.krailo.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.krailo.school.dto.PaymentDto;
import com.krailo.school.entity.Audience;
import com.krailo.school.entity.Payment;
import com.krailo.school.service.PaymentService;
import com.krailo.school.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final StudentService studentService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("payments", paymentService.findAll());      
        return "/payments";
    }
    
    
    
    @GetMapping("/{id}")
    public String findById (@PathVariable("id") Integer id, Model model) {
          model.addAttribute("payment", paymentService.findById(id)); 
          model.addAttribute("students", studentService.findAll());
        return "/payment";        
    }
    
    
    @GetMapping("/payment/new")
    public String createForm (Model model) {
    model.addAttribute("students", studentService.findAll());    
    return "/paymentNew";
    }
    
    
    @PostMapping("/create")
   // @ResponseStatus(HttpStatus.CREATED)
    public String create ( @ModelAttribute PaymentDto payment) {
        System.out.println(payment);
        System.out.println(payment.getStudentId());
        System.out.println(payment.getStudent());
        paymentService.create(payment);  
        return "redirect:/payments";     
    }
    
    @PostMapping("/{id}/update")
    public String update (@PathVariable("id") Integer id, @ModelAttribute PaymentDto payment) {
        System.out.println(payment);
        System.out.println(payment.getStudentId());
        paymentService.update(id, payment); 
        return "redirect:/payments";        
    }
    
    @PostMapping("/{id}/delete")
    public String delete (@PathVariable("id") Integer id) {
         paymentService.delete(id); 
        return "redirect:/payments";        
    }

}
