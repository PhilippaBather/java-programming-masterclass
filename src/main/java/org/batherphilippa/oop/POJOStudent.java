package org.batherphilippa.oop;

import java.time.LocalDate;

public class POJOStudent {
    private String id;
    private String name;
    private LocalDate dob;
    private String classList;

    public POJOStudent(String id, String name, LocalDate dob, String classList) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.classList = classList;
    }

    @Override
    public String toString() {
        return "POJOStudent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", classList='" + classList + '\'' +
                '}';
    }
}
