package org.batherphilippa.controlflow;

import java.util.Arrays;

public class Sum3and5Challenge {
    public static void main(String[] args) {
        sumThreesAndFives(0);
        sumThreesAndFives(-3);
        sumThreesAndFives(1001);
        sumThreesAndFives(3);
        sumThreesAndFives(5);
        sumThreesAndFives(7);
        sumThreesAndFives(1000);
        sumThreesAndFives(15);
        sumThreesAndFives(75);

    }

    public static void sumThreesAndFives(int num) {
        final int MAX_RANGE = 1_000;

        if (num < 15) {
            System.out.printf("\nNo numbers divisible by both 3 and 5 in %d.", num);
        }

        int limit = 0;
        int sum = 0;
        for (int i = 15; (limit < 5) && (i <= MAX_RANGE); i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.printf("%n%d is divisible by 3 and 5.", i);
                sum+= i;
                limit++;
            }
        }

        System.out.printf("%nSum of numbers divisible by 3 and 5 (capped at 5 numbers) is: %d%n", sum);
    }
}
