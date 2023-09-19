package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExamples {
    public static void main(String[] args) {
        record Person(String firstName, String lastName){

        }

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickie", "Mouse")
        ));

        // as the list is local, fields can be directly referenced
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------------");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------------");
        list.sort(Comparator.comparing(Person::lastName)
                        .thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("---------------------------------------");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
                .reversed());
        list.forEach(System.out::println);

    }
}
