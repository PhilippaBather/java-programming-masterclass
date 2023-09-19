package org.batherphilippa.lambdaandfunctionalprogramming.challenges.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Challenge {
    private static final int MIN = 65;
    private static final int MAX = 90;

    private record Person(String firstName) {
        public String lastName(String s) {
            return firstName + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {
        String[] names = {"Anna", "Bob", "Charlie", "Daniela", "Ed", "Fred", "George", "Helen", "Isobel", "Jake", "Kate", "Lucy", "Matt", "Nathan", "Owen", "Philippa"};
        String[] names2 = {"Anna", "Bob", "Charlie"};
        List<String> namesList = new ArrayList<>(List.of(names));

        UnaryOperator<String> toUpperCaseFunc = String::toUpperCase;

        // alternatively, create a separate method
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


        List<UnaryOperator<String>> stringFunctions1 = new ArrayList<>(List.of(toUpperCaseFunc,
                getRandomInitial, appendSurname, capitaliseEveryOtherLetter, getIntegerForName));

        List<UnaryOperator<String>> stringFunctions2 = new ArrayList<>(List.of(
                String::toUpperCase,
                Challenge::getRandomChar // static method ref on the class, String passed as reference

        ));

        // instance method called on an instance using a bounded receiver
        // meaning the instance is coming from code external to the code itself
        Person phil = new Person("Philippa");


        List<UnaryOperator<String>> stringFunctions3 = new ArrayList<>(List.of(
                String::toUpperCase,
                Challenge::getRandomChar,
                Challenge::getReversedName,
                String:: new,
                s -> new String(s),
                String::valueOf,
                phil::lastName,
                (new Person("Maria"))::lastName
        ));

//        applyUnaryMethods(stringFunctions1, names);
//        applyUnaryMethodsReplace(stringFunctions2, names);
        applyUnaryMethodsReplace(stringFunctions3, names);


    }
    private static String getReversedName(String firstName) {
        return new StringBuilder(firstName).reverse().toString();
    }

    // Doesn't modify the Array
    private static <T> void applyUnaryMethods1(List<UnaryOperator<String>> strFunc, String[] names){
        Arrays.asList(names).forEach(name -> strFunc.forEach(f -> System.out.println(name.transform(f::apply))));
    }

    // Use a List backed by an Array to modify the contents of the Array
    private static <T> void applyUnaryMethods2(List<UnaryOperator<String>> strFunc, String[] names){
        List<String> backedByArray = Arrays.asList(names);
        strFunc.forEach(f -> backedByArray.replaceAll(s -> s.transform(f)));
    }

    private static <T> void applyUnaryMethodsReplace(List<UnaryOperator<String>> strFunc, String[] names){
        System.out.println("\n _____________ Apply Unary Methods Replace _____________");
        List<String> backedByArray = Arrays.asList(names);
        for (UnaryOperator<String> func : strFunc) {
            backedByArray.replaceAll(s -> s.transform(func));
            System.out.println(Arrays.toString(names));
        }
    }

    private static String getRandomChar(String s) {
        int randNum = (int) (Math.random() * (MAX - MIN) + MIN);
        return new StringBuilder().append(s).append(" ").append((char) randNum).append(".").toString();
    }
}
