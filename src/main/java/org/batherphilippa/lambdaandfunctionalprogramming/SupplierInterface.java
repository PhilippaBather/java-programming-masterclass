package org.batherphilippa.lambdaandfunctionalprogramming;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierInterface {
    public static void main(String[] args) {
        String[] names = {"Ann", "Bob", "Charlie", "Dave", "Edward", "Fred", "George", "Helen", "Isobel", "Jack", "Kevin", "Lucy", "Matthew", "Nathan", "Owen", "Philippa"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));

    }

    /**
     * Returns an array of Strings with the same number of elements that are passed as the first argument.
     * @param count: number of elements to be returned
     * @param values: an array from which the elements will be returned
     * @param s: used to get an Integer used as an index to pick a name from the values Array
     * @return a String[] of randomly selected values
     */
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
