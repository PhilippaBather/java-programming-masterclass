package org.batherphilippa.lambdaandfunctionalprogramming.challenges.lambdas;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MiniChallenge2and3 {

    private final static String TEST_SENTENCE = "Hello, World! What a lovely day!";

    public static void main(String[] args) {

        // 2. Write the method below as a lambda expression.
        // 3. Call and print out the result to the console.

        Function<String, String> everySecondCharLambda = s -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        };

        // or with UnaryOperator as a String is also to be returned
        UnaryOperator<String> everySecondCharLambdaUnary = s -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        };

        System.out.println("\n---------------------");
        System.out.println(everySecondChar(TEST_SENTENCE)); // original method
        System.out.println("\n---------------------");
        System.out.println(everySecondCharLambda.apply(TEST_SENTENCE));
        System.out.println("\n---------------------");
        System.out.println(everySecondCharLambdaUnary.apply(TEST_SENTENCE));
        System.out.println("\n---------------------");
        System.out.println(everySecondCharLambda.apply("1234567890"));
    }

    public static String everySecondChar(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                stringBuilder.append(source.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
