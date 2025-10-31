package com.krailo.school.report;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krailo.school.entity.Payment;
import com.krailo.school.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Component
public class Bill {
    
    private Student student;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<ItemBill> items;
    private List<Payment> payments;
    int totalItemSum;
    int totalPaymentSum;
    int balance;

    public Bill () {
        
    }
    
    public void calculateTotalItemSum() {
        for (ItemBill i : items) {
            totalItemSum = i.getItemSum() + totalItemSum;
        }
    }

    public void calculateTotalPaymentSum() {
        for (Payment p : payments) {
            totalPaymentSum = p.getValue() + totalPaymentSum;
        }
    }

}
