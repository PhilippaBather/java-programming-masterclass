package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ChainingLambdas {

    public static void main(String[] args) {

        String name = "Phil";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Mitchell");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name)); // PHIL Mitchell

        // compose(): opposite of andThen
        // executes lastName first, then uCase
        // only available to lambda expressions that target either a Function or a UnaryOperator interface
        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name)); // PHIL MITCHELL

        // interim methods don't have to return the same result; only last method must return required output
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Smith"))
                .andThen(s -> s.split(" "));

        System.out.println(Arrays.toString(f0.apply(name)));

        Function<String, String> f1 = uCase.andThen(s -> s.concat(" Charlie"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() +", " + s[0]);
        System.out.println(f1.apply(name));

        Function<String, Integer> f2 = uCase.andThen(s -> s.concat(" Charlie"))
                .andThen(s -> s.split(" "))
                .andThen(s -> s[1].toUpperCase() +", " + s[0])
                .andThen(s -> s.join(", ", s))
                .andThen(String::length);
        System.out.println(f2.apply(name));

        // Convenience Methods on Consumer
        String[] names = {"Anna", "Bob", "Charlie"};
        Consumer<String> s0 = s-> System.out.println(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0.andThen(s -> System.out.print(" - ")).andThen(s1));

        // Convenience Methods on Predicate (return a boolean)
        Predicate<String> p1 = s -> s.equals("PHIL");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("Phil");
        Predicate<String> p3 = s -> s.startsWith("P");
        Predicate<String> p4 = s -> s.endsWith("l");
        Predicate<String> combined1 = p1.or(p2);
        System.out.println("Combined 1: " + combined1.test(name));

        Predicate<String> combined2 = p3.and(p4);
        System.out.println("Combined 2: " + combined2.test(name));

        Predicate<String> combined3 = p3.and(p4).negate();
        System.out.println("Combined 3: " + combined3.test(name));
    }
}
