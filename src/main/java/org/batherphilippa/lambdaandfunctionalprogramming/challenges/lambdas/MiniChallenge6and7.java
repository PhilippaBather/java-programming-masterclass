package org.batherphilippa.lambdaandfunctionalprogramming.challenges.lambdas;

import java.util.function.Supplier;

public class MiniChallenge6and7 {

    public static void main(String[] args) {

        // 6. Write a lambda expression declared with the Supplier interface returning the String "I love Java"
        // and assigned to variable named as such.
        // 7. Call and print out the result to console.
        Supplier<String> iLoveJava = () -> "I love Java";
        System.out.println(iLoveJava.get());
    }
}
