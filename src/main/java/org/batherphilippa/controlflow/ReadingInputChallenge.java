package org.batherphilippa.controlflow;

import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadingInputChallenge {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_AGE = 125;

    public static void main(String[] args) {
        printAge();
    }

    public static void printAge() {
        int yearOfBirth, monthOfBirth, dateOfBirth;

        yearOfBirth = getBirthYearInput();

        monthOfBirth = getBirthMonthInput();

        dateOfBirth = getBirthDateInput(monthOfBirth, yearOfBirth);

        int age = getAge(dateOfBirth, monthOfBirth, yearOfBirth);

        System.out.printf("%nAge: %d", age);
    }

    private static int getBirthYearInput() {
        int birthYear = -1;
        do {
            try {
                System.out.println("Enter year of birth: ");
                birthYear = scanner.nextInt();
                birthYear = checkYearIsValid(birthYear);
            } catch (InputMismatchException e) {
                System.out.println("%nPlease enter a valid year of birth.");
                scanner.next();
            }
        } while (birthYear == -1);

        return birthYear;
    }

    private static int getBirthMonthInput() {
        int birthMonth = -1;
        do {
            try {
                System.out.println("Enter numerical month of birth: ");
                birthMonth = scanner.nextInt();
                birthMonth = checkMonthIsValid(birthMonth);
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid numerical value for the month.");
                scanner.next();
            }
        } while (birthMonth == -1);

        return birthMonth;
    }

    private static int getBirthDateInput(int month, int year) {
        int birthDate = -1;
        do {
            try {
                System.out.println("Enter numerical month of birth: ");
                birthDate = scanner.nextInt();
                birthDate = checkBirthDateIsValid(birthDate, month, year);
            } catch (InputMismatchException e) {
                System.out.println("Please enter date of birth");
                scanner.next();
            }
        } while (birthDate == -1);

        return birthDate;
    }

    private static int checkYearIsValid(int yearOfBirth) {
        LocalDate curDate = LocalDate.now();
        int curYr = curDate.getYear();
        int age = curYr - yearOfBirth;
        return (age <= MAX_AGE) ? yearOfBirth : -1;
    }

    private static int checkMonthIsValid(int monthOfBirth) {
        return ((monthOfBirth > 0) && (monthOfBirth <= 12)) ? monthOfBirth : -1;
    }

    private static int checkBirthDateIsValid(int date, int month, int year) {
        return switch (month) {
            case 2 -> {
                if ((date < 0) || (date > 29)) {
                    yield -1;
                } else if (date < 29){
                    yield date;
                } else {
                    yield (LeapYearsAndMonthsChallenge.isLeapYear(year)) ? 29 : -1;
                }
            }
            case 4, 6, 9, 11 -> ((date > 0) && (date <= 30)) ? date : -1;
            case 1, 3, 5, 7, 8, 10, 12 -> ((date > 0) && (date <= 31)) ? date : -1;
            default -> -1;
        };
    }

    private static int getAge(int date, int month, int year) {
        LocalDate birthDate = LocalDate.of(year, month, date);
        LocalDate curDate = LocalDate.now();
        Period diff = Period.between(birthDate, curDate);
        return diff.getYears();
    }

}
