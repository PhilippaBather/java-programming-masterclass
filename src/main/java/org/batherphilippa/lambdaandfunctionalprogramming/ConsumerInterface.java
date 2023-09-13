package org.batherphilippa.lambdaandfunctionalprogramming;

import org.batherphilippa.lambdaandfunctionalprogramming.demo.Operation;

import java.util.ArrayList;
import java.util.List;

public class ConsumerInterface {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("alpha", "beta", "charlie", "delta"));

        for (String s : stringList) {
            System.out.println(s);
        }

        System.out.println("------- .forEach() ---------");
        stringList.forEach((s) -> System.out.println(s));
        System.out.println("------- .forEach() multiple lines in lambda code block --------");
        final String prefix = "nato";
        stringList.forEach((String s) -> {
            char firstChar = s.charAt(0);
            System.out.printf("\n%s %s means: %s", prefix, s, firstChar);
        });

        System.out.println("\n------- .Consumer Interface: Operation Example ---------");

        int result1 = calculator((a, b) -> a + b, 5, 2);
        double result2 = calculator((a, b) -> a % b, 5, 2);
        double result3 = calculator((a,b) -> a / b, 5.0, 2.0);
        String result4 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Bart", "Simpson");
    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("\nResult of operation: " + result);
        return result;
    }
}
