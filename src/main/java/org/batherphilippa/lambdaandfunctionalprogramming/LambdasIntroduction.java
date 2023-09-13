package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdasIntroduction {

    // records are implicitly static when used as an inner class (as with enums and interfaces)
    // so records can be created using main's class name if want a record outside of the class
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(
                Arrays.asList(
                        new LambdasIntroduction.Person("Lucy", "Van Pelt"), // Main.Person: Why? Implicitly static. Unnecessary here.
                        new Person("Sally", "Brown"),
                        new Person("Linus", "Van Pelt"),
                        new Person("Peppermint", "Patty"),
                        new Person("Charlie", "Brown")
                )
        );

        // creating an anonymous class and assigning it to a variable
//        Comparator<Person> comparatorLastName = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName().compareTo(o2.lastName());
//            }
//        };
//        people.sort(comparatorLastName);

        // or the Comparator can be applied to the method argument
//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.lastName().compareTo(o2.lastName());
//            }
//        });

        // or with a lambda expression
        // where the lambda's parameters are determined by the interface's functional method
        people.sort((o1, o2) -> o1.lastName().compareTo(o2.lastName()));

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        Comparator<Person> comparatorMixed = new EnhancedComparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
        };

        // note: cannot use lambda expression if using comparatorMixed as not a Functional Interface
        // Why? More than one abstract non-overriding method, so Java cannot determine which to use
        people.sort(comparatorMixed);

        // or a method reference with Comparator.comparing()
//        people.sort(Comparator.comparing(Person::lastName));


        System.out.println("People List: Peanuts Characters Ordered Alphabetically by Surname and Forename");
        // Note: Sally before Charlie Brown, and Lucy before Linus Van Pelt due to insertion order
        System.out.println(people);




    }
}
