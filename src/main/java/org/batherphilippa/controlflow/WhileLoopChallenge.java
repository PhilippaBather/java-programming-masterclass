package org.batherphilippa.controlflow;

public class WhileLoopChallenge {
    private static final int START_CONDITION = 5;
    private static final int END_CONDITION = 20;
    private static final int TOTAL_COUNT_CONDITION = 5;

    public static void main(String[] args) {
        checkForEvenNumbers();
    }

    private static boolean isEvenNumber(int number){
        return number % 2 == 0;
    }

    // note: code refactored to remove break and continue statements for readability
    private static void checkForEvenNumbers() {
        int index = START_CONDITION;
        int evenCount = 0;
        int oddCount = 0;

        while((index <= END_CONDITION) && (evenCount < TOTAL_COUNT_CONDITION)) {
            if (!isEvenNumber(index)) {
                oddCount++;
            } else {
                System.out.printf("%n%d is an even number.", index);
                evenCount++;
            }
            index++;
        }
        System.out.printf("%nTotal number of even numbers found: %d.", evenCount);
        System.out.printf("%nTotal number of odd numbers found: %d.", oddCount);
    }
}
