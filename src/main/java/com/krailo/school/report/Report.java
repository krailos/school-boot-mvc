package com.krailo.school.report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.krailo.school.entity.Discount;
import com.krailo.school.entity.Lesson;
import com.krailo.school.entity.LessonsStudents;
import com.krailo.school.entity.Price;
import com.krailo.school.entity.Student;
import com.krailo.school.entity.StudentsDiscounts;
import com.krailo.school.service.DiscountService;
import com.krailo.school.service.LessonService;
import com.krailo.school.service.PaymentService;
import com.krailo.school.service.PriceService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
public class Report {

    private LessonService lessonService;
    private DiscountService discountService;
    private PriceService priceSrvice;
    private PaymentService  paymentService;
  
//    public Bill createBill (Student student, LocalDate startDate, LocalDate endDate) {
//        Bill bill = new Bill();
//        bill.setStudent(student);
//        bill.setStartDate(startDate);
//        bill.setEndDate(endDate);
//        bill.setItems(createItems(student, startDate, endDate));
//        bill.setPayments(paymentDao.findByStudentId(student.getId()));
//        bill.calculateTotalItemSum();
//        bill.calculateTotalPaymentSum();
//        bill.calculeateBalance();
//        return bill;
//        
//       
//        
//    }

    public List<ItemBill> createItems(Student student, LocalDate startDate, LocalDate endDate) {
 
        List<Lesson> lessons = lessonService.findAllByStudentAndBetweenDatesEntity(student, startDate, endDate);
        List<StudentsDiscounts> studentsDiscounts = student.getStudentsDiscounts();
        List<ItemBill> items = new ArrayList<ItemBill>();
        for (Lesson lesson : lessons) {
            ItemBill item = createItem(lesson, student, studentsDiscounts);
            item.calculateItemSum();
            items.add(item);
        }
        return items;
    }

    public ItemBill createItem(Lesson lesson, Student student, List<StudentsDiscounts> studentsDiscounts ) {
        ItemBill item = new ItemBill();
        item.setStudent(student);
        item.setLesson(lesson);
        item.setGang(lesson.getGang());
        item.setSubject(lesson.getSubject());
        item.setDate(lesson.getDate());
        item.setLessonStudent(lesson.getLessonsStudents().get(0));
        
        item.setPrice(lesson.getSubject().getPrices().stream()
                .sorted(Comparator.comparing(Price::getDate).reversed())
                .filter(p -> p.getDate().isBefore(lesson.getDate())
                        || p.getDate().isEqual(lesson.getDate()))
                .findFirst().orElse(null));
        StudentsDiscounts studentDiscount = studentsDiscounts.stream()
                .filter(sd -> sd.getSubject().equals(lesson.getSubject()))
                .sorted(Comparator.comparing(StudentsDiscounts::getDate).reversed())
                .filter(sd -> sd.getDate().isBefore(lesson.getDate()) || sd.getDate().isEqual(lesson.getDate()))
                .findFirst().orElse(null);
         item.setDiscount(studentDiscount.getDiscount());
        return item;
    }

}
