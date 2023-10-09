package org.batherphilippa.oop.challenge;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HourlyEmployee extends Employee {

    private BigDecimal hourlyRatePay;

    public HourlyEmployee(String name, LocalDate dob, LocalDate endDate, LocalDate hireDate, BigDecimal hourlyRatePay) {
        super(name, dob, endDate, hireDate);
        this.hourlyRatePay = hourlyRatePay;
    }

    public BigDecimal getDoublePay(){
        return collectPay().multiply(BigDecimal.valueOf(2));
    }

    @Override
    public BigDecimal collectPay() {
        return hourlyRatePay.multiply(BigDecimal.valueOf(40));
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyRatePay=" + hourlyRatePay +
                "} " + super.toString();
    }
}
