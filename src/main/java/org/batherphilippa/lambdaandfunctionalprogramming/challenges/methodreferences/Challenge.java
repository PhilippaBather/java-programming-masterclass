package org.batherphilippa.lambdaandfunctionalprogramming.challenges.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Challenge {
    private static final int MIN = 65;
    private static final int MAX = 90;

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Charlie", "Daniela", "Ed", "Fred", "George", "Helen", "Isobel", "Jake", "Kate", "Lucy", "Matt", "Nathan", "Owen", "Philippa"};
        List<String> namesList = new ArrayList<>(List.of(names));

        UnaryOperator<String> toUpperCaseFunc = String::toUpperCase;

        UnaryOperator<String> getRandomInitial = (s) -> {
            int randNum = (int) (Math.random() * (MAX - MIN) + MIN);
            return new StringBuilder().append(s).append(" ").append((char) randNum).append(".").toString();
        };

        UnaryOperator<String> appendSurname = (s) -> {
            String surname = getReversedName(s.split(" ")[0]); // pass forename as arg
            return new StringBuilder().append(s).append(" ").append(surname).toString();
        };

        UnaryOperator<String> getIntegerForName = (s) -> {
            int asciiCode =  (int) s.charAt(0);
            return new StringBuilder(String.valueOf(asciiCode)).append(s.substring(1, s.length() - 1)).toString();
        };

        UnaryOperator<String> capitaliseEveryOtherLetter = (s) -> {
            String[] letters = s.split("");
            for (int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                   letters[i] = letters[i].toUpperCase().concat("*");
                }
            }
            return String.join("", letters);
        };


        List<UnaryOperator<String>> stringFunctions = new ArrayList<>(List.of(toUpperCaseFunc,
                getRandomInitial, appendSurname, capitaliseEveryOtherLetter, getIntegerForName));

        applyUnaryMethods(stringFunctions, names);

    }
    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

    private static <T> void applyUnaryMethods(List<UnaryOperator<String>> strFunc, String[] names){
        Arrays.asList(names).forEach(name -> strFunc.forEach(f -> System.out.println(name.transform(f::apply))));
    }
}
