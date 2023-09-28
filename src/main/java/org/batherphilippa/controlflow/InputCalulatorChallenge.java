package org.batherphilippa.controlflow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCalulatorChallenge {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    private static void inputThenPrintSumAndAverage() {
        final Scanner scanner = new Scanner(System.in);

        boolean isExit = false;
        int count = 0;
        int sum = 0;

        do{
            try {
                sum += scanner.nextInt();
                count++;
            } catch(InputMismatchException ime) {
                System.out.printf("SUM = %d AVG = %d", sum, (count != 0 ? Math.round(((double) sum / (double) count)) : 0));
                isExit = true;
            }
        } while(!isExit);
    }
}
