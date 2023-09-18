package org.batherphilippa.lambdaandfunctionalprogramming.challenges.lambdas;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniChallenge1 {
    private final static String TEST_SENTENCE = "Hello, World! What a lovely day!";

    public static void main(String[] args) {


        // 1. Rewrite anonymous class below as a lambda expression
        Consumer<String> printWords1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                String[] parts = s.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWords2 = s -> {
            String[] parts = s.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };

        Consumer<String> printWordsForEach = s -> {
            String[] partsArr = s.split(" ");
            // convert array to List to access List method
            Arrays.asList(partsArr).forEach(p -> System.out.println(p));
        };

        Consumer<String> printWordsConcise = s ->
            Arrays.asList(s.split(" ")).forEach(p -> System.out.println(p));


        printWords1.accept(TEST_SENTENCE);  // with anonymous class
        System.out.println("\n---------------------");
        printWords2.accept(TEST_SENTENCE);
        System.out.println("\n---------------------");
        printWordsForEach.accept(TEST_SENTENCE);
        System.out.println("\n---------------------");
        printWordsConcise.accept(TEST_SENTENCE);
        System.out.println("\n---------------------");
        printParts1(TEST_SENTENCE, printWords2);

    }

    public static void printParts1(String sentence, Consumer<String> consumer) {
        consumer.accept(sentence);
    }
}
