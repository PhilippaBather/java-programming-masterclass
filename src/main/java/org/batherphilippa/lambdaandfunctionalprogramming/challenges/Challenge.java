package org.batherphilippa.lambdaandfunctionalprogramming.challenges;

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

        UnaryOperator<String> getRandomInitial = (s) -> {
            StringBuilder sb = new StringBuilder();
            int randNum = (int) (Math.random() * (MAX - MIN) + MIN);
            return sb.append(s).append(" ").append((char) randNum).append(".").toString();
        };

        UnaryOperator<String> appendSurname = (s) -> {
            String[] name = s.split(" ");
            String surname = reverseWord(name[0]); // pass forename as arg
            StringBuilder sb = new StringBuilder();
            return sb.append(s).append(" ").append(surname).toString();
        };

        UnaryOperator<String> removeSurnameIdenticalToForename = (s) -> {
            String[] name = s.split(" ");
            int endIndex = name[0].length() + name[1].length() + 1; // + 1 to account for zero indexing
            if (name[0].equals(name[2])) {
                s = s.substring(0, endIndex);
            }
            return s;
        };

        // 1.1 Use Arrays.setAll() to transform all names to uppercase
        System.out.println("\n----- Arrays.setAll(): Uppercase -----");
        Arrays.setAll(names, i -> names[i].toUpperCase());
//        System.out.println(Arrays.toString(names));
        Arrays.asList(names).forEach(name -> System.out.println(name));

        // 1.2 Add a randomly generated middle initial, and include a period.
        System.out.println("\n----- Arrays.setAll(): With Initial Followed by a Period -----");
        Arrays.setAll(names, i -> getFuncValue(getRandomInitial, names[i]));
//        System.out.println(Arrays.toString(names));
        Arrays.asList(names).forEach(name -> System.out.println(name));

        // 1.3 Add a surname that is the reverse of the forename
        System.out.println("\n----- Arrays.setAll(): Add Surname that is the Reverse of the Forename -----");
        Arrays.setAll(names, i -> getFuncValue(appendSurname, names[i]));
//        System.out.println(Arrays.toString(names));
        Arrays.asList(names).forEach(name -> System.out.println(name));

        // 2.1 Use the List.replaceAll() to change the names within the names Array
        System.out.println("\n----- List.replaceAll() -----");
//        Arrays.asList(names).replaceAll(n -> n.toUpperCase());
        // or using List
        namesList.replaceAll(n -> n.toUpperCase());
        namesList.forEach(n -> System.out.println(n));

        // 2.2 Add a randomly generated middle initial, and include a period.
        System.out.println("\n----- List.replaceAll(): With Initial Followed by a Period -----");
        namesList.replaceAll(n -> getFuncValue(getRandomInitial, n));
        namesList.forEach(n -> System.out.println(n));

        // 2.3 Add a surname that is the reverse of the forename
        System.out.println("\n----- List.replaceAll(): Add Surname that is the Reverse of the Forename -----");
        namesList.replaceAll(n -> getFuncValue(appendSurname, n));
        namesList.forEach(n -> System.out.println(n));

        // 3. Create a modifiable ArrayList from your names Array,
        // removing any names where the last name equals the first reversed.
        System.out.println("\n----- List.replaceAll(): Remove Surnames Identical to Forename -----");
        Arrays.asList(names).replaceAll(n -> getFuncValue(removeSurnameIdenticalToForename, n));
        Arrays.asList(names).forEach(n -> System.out.println(n));

    }

    public static String getFuncValue(UnaryOperator<String> func, String s) {
        return func.apply(s);
    }

    public static String reverseWord(String s) {
        StringBuilder reversedWord = new StringBuilder();
        for(int i = s.length() -1; i >= 0; i--){
            reversedWord.append(s.charAt(i));
        }
        return reversedWord.toString();
    }
}
