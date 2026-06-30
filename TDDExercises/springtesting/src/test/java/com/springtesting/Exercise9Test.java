package com.springtesting;

import com.springtesting.service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise9Test {

    private CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "5, 5, 10",
        "0, 0, 0",
        "10, 20, 30",
        "100, 200, 300"
    })
    public void testAdd(int a, int b, int expected) {
        int result = calculatorService.add(a, b);
        assertEquals(expected, result);
    }
}
