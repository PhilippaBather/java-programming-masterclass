package org.batherphilippa.controlflow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MinMaxChallenge {

    public static void main(String[] args) {
        getMinAndMaxNumbers();
    }

   private static void getMinAndMaxNumbers() {
        final Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        int count = 0;
        int minNum = 0, maxNum = 0;

        do{
            try {
                System.out.println("\nEnter a number or any character to quit.");
                int num = scanner.nextInt();
                if (count == 0) {
                    minNum = num;
                    maxNum = num;
                    count++;
                } else {
                    minNum = Math.min(num, minNum);
                    maxNum = Math.max(num, maxNum);
                }
            } catch (InputMismatchException e) {
                System.out.println("Programme quitting.");
                exit = true;
            }
            scanner.nextLine();
        } while(!exit);

        if (count == 0) {
            System.out.println("No numbers entered: no minimum or max number.");
            return;
        }

        System.out.printf("%nMin number: %d%nMax num: %d%n", minNum, maxNum);


    }
}
