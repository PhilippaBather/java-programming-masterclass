package org.batherphilippa.controlflow;

public class SwitchStatementsChallenge {

    public static void main(String[] args) {

        System.out.println(getNatoAlphabet('d'));
        System.out.println(getNatoAlphabet('a'));
        System.out.println(getNatoAlphabet('c'));
        System.out.println(getNatoAlphabet('z'));

        System.out.println("--------- Enhanced Switch: Nato Alphabet ----------");
        System.out.println(getNatoAlphabetEnhanced('d'));
        System.out.println(getNatoAlphabetEnhanced('a'));
        System.out.println(getNatoAlphabetEnhanced('c'));
        System.out.println(getNatoAlphabetEnhanced('z'));

        System.out.println("--------- Enhanced Switch: Day of the Week ----------");
        System.out.println(getDayOfWeek(0));
        System.out.println(getDayOfWeek(2));
        System.out.println(getDayOfWeek(10));
    }

    private static String getNatoAlphabet(char c) {
        switch(Character.toUpperCase(c)) {
            case 'A':
                return "Alfa";
            case 'B':
                return "Bravo";
            case 'C':
                return "Charlie";
            case 'D':
                return "Delta";
            case 'E':
                return "Echo";
            default:
                return "Character not recognised.";
        }
    }

    private static String getNatoAlphabetEnhanced(char c) {
        return switch(Character.toUpperCase(c)) {
            case 'A' -> "Alfa";
            case 'B' -> "Bravo";
            case 'C' -> "Charlie";
            case 'D' -> "Delta";
            case 'E' -> "Echo";
            default -> "Character not recognised.";
        };
    }

    private static String getDayOfWeek(int numOfWeek) {
        return switch(numOfWeek) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid day";
        };
    }
}
