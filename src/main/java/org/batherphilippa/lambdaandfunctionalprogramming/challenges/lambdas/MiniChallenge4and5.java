package org.batherphilippa.lambdaandfunctionalprogramming.challenges.lambdas;

import java.util.function.Function;

public class MiniChallenge4and5 {

    private static final String TEST_STRING = "1234567890";
    public static void main(String[] args) {

        // 4. Instead of executing function directly, pass it to a method.
        // So, create a method that is the target for a lambda expression.
        // Allows for extensible code.
        // 5. Call and print out the result to the console.

        Function<String, String> everySecondString = s -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(i % 2 == 1) {
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        };

        String result = applyStringFunc(everySecondString, TEST_STRING);
        System.out.println(result);

    }

    public static String applyStringFunc(Function<String, String> func, String s) {
        return func.apply(s);
    }
}
