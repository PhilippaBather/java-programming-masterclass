package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionInterface {

    public static void main(String[] args) {
        System.out.println("\n------- Functional Interface ---------");

        List<String> natoAlphabet = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel"));

        // unary operator: takes 1 arg, returns result of same type
        // replaceAll has access to each element
        natoAlphabet.replaceAll(s -> s.charAt(0) + " _  " + s.toUpperCase());
        natoAlphabet.forEach(s -> System.out.println(s));

        System.out.println("----------------------------------");
        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
        // setAll: has access to each index in the Array
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("------------ With Switch expression----------------------");
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
                + switch (i) {
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyStrings));



    }
}
