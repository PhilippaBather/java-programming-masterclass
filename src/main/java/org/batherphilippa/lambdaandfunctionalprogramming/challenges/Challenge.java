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

        UnaryOperator<String> reverseWord = (s) -> {
            String[] name = s.split(" ");
            String forename = name[0];
            StringBuilder sb = new StringBuilder();
            String surname = "";
            for(int i = forename.length() -1; i >= 0; i--){
                surname += s.charAt(i);
            }
          return sb.append(s).append(" ").append(surname).toString();
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
        Arrays.setAll(names, i -> getFuncValue(reverseWord, names[i]));
//        System.out.println(Arrays.toString(names));
        Arrays.asList(names).forEach(name -> System.out.println(name));

        // 2.1 Use the List.replaceAll() to change the names within the names Array
        System.out.println("\n----- List.replaceAll() -----");
//        Arrays.asList(names).replaceAll(n -> n.toUpperCase());
        // or using List
        namesList.replaceAll(n -> n.toUpperCase());
        namesList.forEach(n -> System.out.println(n));

        // 1.2 Add a randomly generated middle initial, and include a period.
        System.out.println("\n----- List.replaceAll(): With Initial Followed by a Period -----");
        namesList.replaceAll(n -> getFuncValue(getRandomInitial, n));
        namesList.forEach(n -> System.out.println(n));

        System.out.println("\n----- List.replaceAll(): Add Surname that is the Reverse of the Forename -----");
        namesList.replaceAll(n -> getFuncValue(reverseWord, n));
        namesList.forEach(n -> System.out.println(n));

    }

    public static String getFuncValue(UnaryOperator<String> func, String s) {
        return func.apply(s);
    }
}
