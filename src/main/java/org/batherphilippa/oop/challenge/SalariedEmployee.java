package org.batherphilippa.oop.challenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private BigDecimal annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, LocalDate dob, LocalDate endDate, LocalDate hireDate, BigDecimal annualSalary, boolean isRetired) {
        super(name, dob, endDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
    public BigDecimal collectPay() {
        BigDecimal payCheck = annualSalary.divide(BigDecimal.valueOf(26), 2, RoundingMode.HALF_UP);
        return isRetired ? (payCheck.multiply(BigDecimal.valueOf(0.9))) : payCheck;
    }

    public void retire() {
        super.terminate(this.endDate);
        isRetired = true;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "isRetired=" + isRetired +
                "} " + super.toString();
    }
}
