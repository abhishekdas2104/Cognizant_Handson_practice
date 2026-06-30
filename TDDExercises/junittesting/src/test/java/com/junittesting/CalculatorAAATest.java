package com.junittesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorAAATest {

    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @After
    public void tearDown() {
        calc = null;
    }

    @Test
    public void testAdd() {
        int num1 = 10;
        int num2 = 5;
        int result = calc.add(num1, num2);
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int num1 = 20;
        int num2 = 8;
        int result = calc.subtract(num1, num2);
        assertEquals(12, result);
    }

    @Test
    public void testMultiply() {
        int num1 = 6;
        int num2 = 7;
        int result = calc.multiply(num1, num2);
        assertEquals(42, result);
    }

    @Test
    public void testDivide() {
        double num1 = 15.0;
        double num2 = 3.0;
        double result = calc.divide(num1, num2);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testIsEven() {
        int evenNumber = 8;
        int oddNumber = 9;
        boolean resultForEven = calc.isEven(evenNumber);
        boolean resultForOdd = calc.isEven(oddNumber);
        assertTrue(resultForEven);
        assertFalse(resultForOdd);
    }

    @Test
    public void testNumberToString() {
        int positiveNumber = 42;
        int negativeNumber = -1;
        String resultForPositive = calc.numberToString(positiveNumber);
        String resultForNegative = calc.numberToString(negativeNumber);
        assertEquals("42", resultForPositive);
        assertNull(resultForNegative);
    }
}
