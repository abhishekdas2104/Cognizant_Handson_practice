package com.junittesting;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    @Test
    public void testMoreAssertions() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
        assertEquals(3.14, 3.14159, 0.01);
        String str = "hello";
        assertSame(str, str);
        String a = new String("hello");
        String b = new String("hello");
        assertNotSame(a, b);
    }

    @Test
    public void testCalculatorAssertions() {
        Calculator calc = new Calculator();
        assertTrue(calc.isEven(4));
        assertFalse(calc.isEven(7));
        assertNull(calc.numberToString(-5));
        assertNotNull(calc.numberToString(10));
        assertEquals("10", calc.numberToString(10));
    }
}
