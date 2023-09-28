package org.batherphilippa.controlflow;

public class DigitSumChallenge {

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(9153));
        System.out.println(sumDigits(1000));
        System.out.println(sumDigits(3));
    }

    private static int sumDigits(int number){
        if(number < 0) {
            return -1;
        }

        int sum = 0;
        int modulo = 10;
        while(number > 0) {
            int remainder = number % modulo;
            sum += remainder;
            number = (number / modulo); // Using ints, so decimal truncated, so equation same as (number - remainder) / modulo,
        }
        return sum;
    }
}
