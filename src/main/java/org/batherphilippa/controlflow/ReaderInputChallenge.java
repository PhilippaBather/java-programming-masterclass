package org.batherphilippa.controlflow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReaderInputChallenge {

    public static void main(String[] args) {
//        System.out.println(sumFiveInputtedIntegers());
        System.out.println(sumFiveInputtedDecimalNumbers());
    }

    private static int sumFiveInputtedIntegers() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += getNumber(i + 1);
        }
        return sum;
    }

    private static int getNumber(int index) {
        final Scanner scanner = new Scanner(System.in);

        boolean isValidInput = false;
        int num = -1;

        do{
            System.out.printf("%nEnter number #%d: ", index);
            try {
                 num = scanner.nextInt();
                 isValidInput = true;
            } catch(InputMismatchException e) {
                System.out.printf("Invalid number.");
                scanner.next();
            }

        } while(!isValidInput);
        return num;
    }

    private static double sumFiveInputtedDecimalNumbers() {
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += getDecimalNumber(i + 1);
        }
        return sum;
    }

    private static double getDecimalNumber(int index) {
        final Scanner scanner = new Scanner(System.in);

        boolean isValidInput = false;
        double num = -1d;

        do{
            System.out.printf("%nEnter number #%d: ", index);
            try {
                num = scanner.nextDouble();
                isValidInput = true;
            } catch(InputMismatchException e) {
                System.out.printf("Invalid number.");
                scanner.next();
            }

        } while(!isValidInput);
        return num;
    }
}
