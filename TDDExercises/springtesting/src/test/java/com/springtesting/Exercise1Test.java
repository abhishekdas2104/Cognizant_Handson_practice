package com.springtesting;

import com.springtesting.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise1Test {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(3, 5);
        assertEquals(8, result);
    }
}
