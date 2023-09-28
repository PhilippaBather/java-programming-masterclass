package org.batherphilippa.methods;

import java.text.DecimalFormat;

public class MethodOverloading {

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;

    public static void main(String[] args) {
        System.out.println(getDurationString(60)); // 00h 1m 0s
        System.out.println(getDurationString(160)); // 00h 2m 40s
        System.out.println(getDurationString(3601)); // 1hr 0m 1s
        System.out.println(getDurationString(60, 125)); // 1h 2m 5s
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-65, 45));
    }
    public static String getDurationString(int seconds) {
        if (seconds < 0 ) {
            return "Seconds entered is invalid.  Please enter 0 or more seconds.";
        }
        int remainingSec = seconds % SECONDS_IN_MINUTE;
        int mins = seconds / SECONDS_IN_MINUTE;
        return getDurationString(mins, remainingSec);
    }

    public static String getDurationString(int minutes, int seconds) {
        DecimalFormat decimalFormat = new DecimalFormat("00");
        if ((minutes < 0) || (seconds < 0 || seconds > 59)) {
            return "Input is invalid.  Minutes should be greater or equal to 0 and less than or equal to 59; seconds should be greater than 0";
        }

        int hrs = minutes / MINUTES_IN_HOUR;
        int remainingMin = minutes % MINUTES_IN_HOUR;

        return String.format("%sh %sm %ss", decimalFormat.format(hrs), decimalFormat.format(remainingMin), decimalFormat.format(seconds));
    }

}
