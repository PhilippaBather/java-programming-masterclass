package org.batherphilippa.lambdaandfunctionalprogramming;

import org.batherphilippa.lambdaandfunctionalprogramming.demo.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

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

        System.out.println("\n------- Consumer Interface: Operation Example ---------");

        int result1 = calculator2((a, b) -> a + b, 5, 2);
        double result2 = calculator2((a, b) -> a % b, 5, 2);
        double result3 = calculator2((a,b) -> a / b, 5.0, 2.0);
        String result4 = calculator2((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Bart", "Simpson");


        System.out.println("\n------- Mississippi River Coordinates ---------");

        List<double[]> coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

        coords.forEach(p -> System.out.println(Arrays.toString(p)));

        BiConsumer<Double, Double> printPoint = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        double[] firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], printPoint);
        System.out.println("\n------- Mississippi River Coordinates Using BiConsumer ---------");
        // using method definition
        coords.forEach(p -> processPoint(p[0], p[1], printPoint));
        // including the method in the params; note nested lambda
        coords.forEach(p -> processPoint(p[0], p[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

    }

    // using mock up of the pre-existing functional interface, BinaryOperator
    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("\nResult of operation: " + result);
        return result;
    }

    // using predefined functional interface, BinaryOperator
    public static <T> T calculator2(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("\nResult of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
        consumer.accept(t1, t2);
    }
}
