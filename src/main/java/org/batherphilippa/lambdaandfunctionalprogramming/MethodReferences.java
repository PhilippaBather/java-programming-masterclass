package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class ExampleClass {
    private static int last_id = 1;

    private int id;
    public ExampleClass() {
        this.id = ExampleClass.last_id++;
        System.out.println("Creating an example object.");
    }
}

public class MethodReferences {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Charlie", "Dave"));

        // instance method of a particular (bounded) object
        names.forEach(System.out::println );

        calculator((a, b) -> a + b, 10, 25);
        calculator((a, b) -> a + b, 2.5, 7.3);
        // method references using static methods
        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 2.5, 7.3);

        Supplier<ExampleClass> reference1 = () -> new ExampleClass();

        // constructor method reference
        // not immediately executed at time declared
        Supplier<ExampleClass> reference2 = ExampleClass::new;
        ExampleClass newEx1 = reference1.get();
        // executed at point targeted functional method called
        ExampleClass newEx2 = reference2.get();

        System.out.println("Getting array");
        ExampleClass[] exArr = seedArray(ExampleClass::new, 10);

        calculator((s1, s2) -> s1.concat(s2), "Hello, ", "World!");
        calculator(String::concat, "Hello, ", "World!");

        // instance method of an arbitrary (unbounded) object
        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
//        UnaryOperator<String> u1 = ((s1, s2) -> s1.concat(s2)); // can't work, only accepts 1 param
//        UnaryOperator<String> u2 = String::concat; // can't work, only accepts 1 param
        // contrast
        UnaryOperator<String> u3 = String::toUpperCase; // action is performed on one param

        System.out.println(b1.apply("Hello, ", "World"));
        System.out.println(b2.apply("Hello, ", "World"));
        System.out.println(u3.apply("Hello"));

        String result = "Hello".transform(u3);
        System.out.println("Result = " + result);
        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean0 = result.transform(f0);
        // or
        boolean resultBoolean1 = result.transform(String::isEmpty);
        System.out.println("Result = " + resultBoolean0);
        System.out.println("Result = " + resultBoolean1);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static ExampleClass[] seedArray(Supplier<ExampleClass> reference, int count) {
        ExampleClass[] arr = new ExampleClass[count];
        Arrays.setAll(arr, i -> reference.get());
        return arr;
    }
}
