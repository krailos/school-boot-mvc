package com.krailo.school.report;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.krailo.school.entity.Discount;
import com.krailo.school.entity.Gang;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.entity.Price;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.Subject;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Component
public class ItemBill {
    
    private Student student;
    private Discount discount;
    private Lesson lesson; 
    private Subject subject;
    private Price price;
    private LocalDate date;
    private Gang gang;
    private LessonsStudents lessonStudent;
    private int itemSum;

    public ItemBill() {

    }

    public void calculateItemSum() {
        int discountValue = 0;
        if (discount != null) {
            discountValue =  Optional.ofNullable(discount.getValue()).orElse(0);
        }
        int priceSum = price.getValue();
        itemSum = priceSum - priceSum * discountValue / 100;

    }

}
