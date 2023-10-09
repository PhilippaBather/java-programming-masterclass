package org.batherphilippa;

import net.bytebuddy.asm.Advice;
import org.batherphilippa.oop.challenge.Employee;
import org.batherphilippa.oop.challenge.HourlyEmployee;
import org.batherphilippa.oop.challenge.SalariedEmployee;
import org.batherphilippa.oop.challenge.Worker;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public record RecordStudent(String id, String name, LocalDate dob, String classList) {}

    public static void main(String[] args) {

//        System.out.println("\n--------- Using POJO ---------");
//
//
//        for (int i = 1; i <= 5; i++) {
//            POJOStudent s = new POJOStudent("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    }, LocalDate.of(1985, 11, 5), "Java Masterclass");
//            System.out.println(s);
//        }
//
//        System.out.println("\n--------- Using Record ---------");
//
//        for (int i = 1; i <= 5; i++) {
//            RecordStudent s = new RecordStudent("S92300" + i,
//                    switch (i) {
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        case 5 -> "Lisa";
//                        default -> "Anonymous";
//                    }, LocalDate.of(1985, 11, 5), "Java Masterclass");
//            System.out.println(s);
//        }

        Worker worker = new Worker("Pip", LocalDate.of(1990, 7, 2), LocalDate.of(2025, 2, 2));
        System.out.println(worker);
        Employee employee = new Employee("Pat", LocalDate.of(1977, 2, 1), LocalDate.of(2024, 1, 1), LocalDate.of(2020, 1, 1));
        System.out.println(employee);
        System.out.println(employee.getAge());
        System.out.println(employee.collectPay());
        SalariedEmployee salariedEmployee = new SalariedEmployee("Patricia",
                LocalDate.of(1977, 2, 1),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2020, 1, 1),
                new BigDecimal("32000"),
                false
        );
        System.out.println(salariedEmployee.collectPay());
        salariedEmployee.retire();
        System.out.println(salariedEmployee.collectPay());
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Paddy", LocalDate.of(1987, 3, 23),
                LocalDate.of(2024, 2, 2),
                LocalDate.of(2023, 1, 12),
                new BigDecimal("15.67")
        );
        System.out.println(hourlyEmployee);
        System.out.println(hourlyEmployee.getDoublePay());

    }

}