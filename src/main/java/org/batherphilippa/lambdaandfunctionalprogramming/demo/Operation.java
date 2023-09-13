package org.batherphilippa.lambdaandfunctionalprogramming.demo;

@FunctionalInterface
public interface Operation<T> {
    /**
     * Takes two arguments of the same type and returns an argument of that same type.
     * One abstract message.
     * @param value1
     * @param value2
     * @return a value for the operation passed
     */
    T operate(T value1, T value2);
}
