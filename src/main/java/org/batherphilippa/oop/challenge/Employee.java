package org.batherphilippa.oop.challenge;

import java.time.LocalDate;

public class Employee extends Worker {
    private static long employeeNumber = 1L;
    private final long employeeId;
    private final LocalDate hireDate;

    public Employee(String name, LocalDate dob, LocalDate endDate, LocalDate hireDate) {
        super(name, dob, endDate);
        this.employeeId = employeeNumber;
        this.hireDate = hireDate;
        employeeNumber++;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate=" + hireDate +
                "} " + super.toString();
    }
}
