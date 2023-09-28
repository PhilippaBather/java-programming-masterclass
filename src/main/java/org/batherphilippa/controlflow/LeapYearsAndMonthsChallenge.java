package org.batherphilippa.controlflow;

public class LeapYearsAndMonthsChallenge {

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020)); // 31
        System.out.println(getDaysInMonth(2, 2020)); // 29
        System.out.println(getDaysInMonth(2, 2018)); // 28
        System.out.println(getDaysInMonth(-1, 2020)); // -1
        System.out.println(getDaysInMonth(1, -2020)); // -1

        System.out.println("--------- with traditional switch ---------");
        System.out.println(getDaysInMonthTradSwitch(1, 2020)); // 31
        System.out.println(getDaysInMonthTradSwitch(2, 2020)); // 29
        System.out.println(getDaysInMonthTradSwitch(2, 2018)); // 28
        System.out.println(getDaysInMonthTradSwitch(-1, 2020)); // -1
        System.out.println(getDaysInMonthTradSwitch(1, -2020)); // -1
    }

    public static boolean isLeapYear(int year){
        if((year < 1) || (year > 9999)) {
            return false;
        }

        boolean isLeapYear = false;
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
            isLeapYear = true;
        }
        return isLeapYear;
    }

    private static int getDaysInMonth(int month, int year) {
        // guard clause: invalid year input
        if ((year < 1) || (year > 9999)) {
            return -1;
        }

        // switch to check remaining months
        return switch(month) {
            case 2 -> isLeapYear(year) ? 28 : 29; // February
            case 4, 6, 9, 11 -> 30; // April, June, September, November
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // remaining
            default -> -1;
        };
    }

    private static int getDaysInMonthTradSwitch(int month, int year) {
        // guard clause: invalid year input
        if ((year < 1) || (year > 9999)) {
            return -1;
        }

        // switch to check remaining months
        int daysInMonth;
        switch(month) {
            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                daysInMonth = 30;
                break;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                daysInMonth = 31;
                break;
            default:
                daysInMonth = -1;
                break;
        }
        return daysInMonth;
    }
}
