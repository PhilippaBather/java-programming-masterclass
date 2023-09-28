package org.batherphilippa;

import org.batherphilippa.oop.POJOStudent;

import java.time.LocalDate;

public class Main {

    public record RecordStudent(String id, String name, LocalDate dob, String classList) {}

    public static void main(String[] args) {

        System.out.println("\n--------- Using POJO ---------");


        for (int i = 1; i <= 5; i++) {
            POJOStudent s = new POJOStudent("S92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    }, LocalDate.of(1985, 11, 5), "Java Masterclass");
            System.out.println(s);
        }

        System.out.println("\n--------- Using Record ---------");

        for (int i = 1; i <= 5; i++) {
            RecordStudent s = new RecordStudent("S92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        case 5 -> "Lisa";
                        default -> "Anonymous";
                    }, LocalDate.of(1985, 11, 5), "Java Masterclass");
            System.out.println(s);
        }
    }

}