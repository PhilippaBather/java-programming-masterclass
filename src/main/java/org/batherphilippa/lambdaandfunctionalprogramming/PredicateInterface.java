package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.ArrayList;
import java.util.List;

public class PredicateInterface {

    public static void main(String[] args) {
        System.out.println("\n------- Predicate Interface ---------");

        List<String> stringList = new ArrayList<>(List.of("alpha", "beta", "charlie", "delta"));
        stringList.removeIf(s -> s.equalsIgnoreCase("charlie"));
        System.out.println("--- charlie removed ---");
        stringList.forEach(s -> System.out.println(s));
        System.out.println("--- ea removed ---");
        stringList.addAll(List.of("echo", "easy", "earnest"));
        stringList.removeIf(s -> s.startsWith("ea"));
        stringList.forEach(s -> System.out.println(s));
    }
}
