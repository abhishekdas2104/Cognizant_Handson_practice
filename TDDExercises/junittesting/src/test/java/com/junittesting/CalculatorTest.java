package com.junittesting;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 2);
        org.junit.Assert.assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);
        org.junit.Assert.assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);
        org.junit.Assert.assertEquals(12, result);
    }

    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);
        org.junit.Assert.assertEquals(5.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        Calculator calc = new Calculator();
        calc.divide(5, 0);
    }
}
