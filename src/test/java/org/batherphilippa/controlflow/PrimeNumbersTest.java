package org.batherphilippa.controlflow;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrimeNumbersTest {

    @Test
    public void checkZeroIsNotPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(0);
        assertThat(isPrime).isFalse();
    }

    @Test
    public void checkOneIsNotPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(1);
        assertThat(isPrime).isFalse();
    }

    @Test
    public void checkTwoIsPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(2);
        assertThat(isPrime).isTrue();
    }
    @Test
    public void checkThreeIsPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(3);
        assertThat(isPrime).isTrue();
    }

    @Test
    public void checkEightIsNotPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(8);
        assertThat(isPrime).isFalse();
    }

    @Test
    public void checkSeventeenIsPrime() {
        boolean isPrime = PrimeNumbersChallenge.isPrimeNumber(17);
        assertThat(isPrime).isTrue();
    }

    @Test
    public void check1001IsInvalidInput() {
        int count = PrimeNumbersChallenge.countPrimes(1001);
        assertThat(count).isEqualTo(0);
    }

    // 2, 3, 5, 7, 11, 13, 17
    @Test
    @Disabled
    public void check17ContainsSevenPrimes() {
        int count = PrimeNumbersChallenge.countPrimes(17);
        assertThat(count).isEqualTo(7);
    }

    // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    @Test
    @Disabled
    public void check30ContainsTenPrimes() {
        int count = PrimeNumbersChallenge.countPrimes(17);
        assertThat(count).isEqualTo(7);
    }

    @Test
    public void check17ContainsBreaksAtThreePrimeCounts() {
        int count = PrimeNumbersChallenge.countPrimes(17);
        assertThat(count).isEqualTo(3);
    }

}