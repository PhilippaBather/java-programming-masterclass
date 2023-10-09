package org.batherphilippa.oop.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

public class Worker {
    private String name;
    private LocalDate dob;
    protected LocalDate endDate;

    public Worker(String name, LocalDate dob, LocalDate endDate) {
        this.name = name;
        this.dob = dob;
        this.endDate = endDate;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public BigDecimal collectPay() {
        return new BigDecimal(0.0d);
    }

    public LocalDate terminate(LocalDate endDate) {
        this.endDate = endDate;
        System.out.printf("Terminating contract on: %s%n", endDate);
        return this.endDate;

    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", endDate=" + endDate +
                '}';
    }
}
