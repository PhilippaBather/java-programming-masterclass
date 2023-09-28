package org.batherphilippa.controlflow;

public class PrimeNumbersChallenge {
    public static int countPrimes(int range) {
        int primeCount = 0;

        if (range > 1_000) {
            System.out.printf("%n%d: input range must be less than or equal to 1000.", range);
            return primeCount;
        }

        for (int i = 2; primeCount < 3; i++) {
            if (isPrimeNumber(i)) {
                System.out.printf("%n%d is a prime number.", i);
                primeCount++;
            }
            // better: modify for condition to reflect count
//            if(primeCount == 3) {
//                break;
//            }
        }
        return primeCount;
    }

    public static boolean isPrimeNumber(int wholeNum) {
        if(wholeNum < 2) {
            return false;
        }

        // anything divisible by smallest number 2, will also be divisible by whole number divided by 2
        for (int i = 2; i <= wholeNum / 2; i++) {
            if(wholeNum % i == 0) {
                return false;
            }
        }
        return true; // catches 2, as this bypasses the for loop
    }
}
