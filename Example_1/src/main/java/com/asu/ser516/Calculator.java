package com.asu.ser516;

/**
 * Simple Calculator class for basic arithmetic operations.
 * 
 * Taiga Task: TG-1 - Implement Calculator Class
 * User Story: As a user, I want to perform basic arithmetic operations
 */
public class Calculator {

    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts second number from first
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides first number by second
     * @param a dividend
     * @param b divisor
     * @return quotient of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    /**
     * Calculates the power of a number
     * @param base base number
     * @param exponent power to raise to
     * @return base raised to the power of exponent
     */
    public double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Calculates square root of a number
     * @param number the number to find square root of
     * @return square root of the number
     * @throws IllegalArgumentException if number is negative
     */
    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }
}
