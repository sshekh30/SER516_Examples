package com.asu.ser516;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * JUnit tests for Calculator class
 * 
 * Taiga Task: TG-3 - Write Unit Tests for Calculator
 * Tests verify all arithmetic operations work correctly
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddPositiveNumbers() {
        // Taiga Issue: TG-3.1 - Test addition of positive numbers
        assertEquals(5, calculator.add(2, 3));
        assertEquals(100, calculator.add(50, 50));
    }

    @Test
    public void testAddNegativeNumbers() {
        // Taiga Issue: TG-3.2 - Test addition with negative numbers
        assertEquals(-5, calculator.add(-2, -3));
        assertEquals(0, calculator.add(-5, 5));
    }

    @Test
    public void testSubtract() {
        // Taiga Issue: TG-3.3 - Test subtraction operation
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        // Taiga Issue: TG-3.4 - Test multiplication operation
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-10, calculator.multiply(5, -2));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void testDivide() {
        // Taiga Issue: TG-3.5 - Test division operation
        assertEquals(2.0, calculator.divide(6, 3), 0.001);
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
        assertEquals(-2.0, calculator.divide(10, -5), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // Taiga Issue: TG-3.6 - Test division by zero throws exception
        calculator.divide(5, 0);
    }

    @Test
    public void testPower() {
        // Taiga Issue: TG-3.7 - Test power operation
        assertEquals(8.0, calculator.power(2, 3), 0.001);
        assertEquals(1.0, calculator.power(5, 0), 0.001);
        assertEquals(0.25, calculator.power(2, -2), 0.001);
    }

    @Test
    public void testSquareRoot() {
        // Taiga Issue: TG-3.8 - Test square root operation
        assertEquals(3.0, calculator.squareRoot(9), 0.001);
        assertEquals(5.0, calculator.squareRoot(25), 0.001);
        assertEquals(0.0, calculator.squareRoot(0), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootOfNegative() {
        // Taiga Issue: TG-3.9 - Test square root of negative throws exception
        calculator.squareRoot(-1);
    }

    @Test
    public void testChainedOperations() {
        // Taiga Issue: TG-3.10 - Test multiple operations together
        int result = calculator.add(calculator.multiply(2, 3), calculator.subtract(10, 5));
        assertEquals(11, result);
    }
}
