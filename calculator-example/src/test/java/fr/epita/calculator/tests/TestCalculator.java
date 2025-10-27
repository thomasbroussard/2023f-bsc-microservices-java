package fr.epita.calculator.tests;

import fr.epita.calculator.service.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculator {


    @Test
    void shouldDivideTwoNumbers() {
        Calculator calc = new Calculator();
        double result = calc.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    void shouldThrowExceptionWhenDividingByZero() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class,
                () -> calc.divide(10, 0));
    }

    /*
    Create a method add(String numbers) that returns sum
Empty string returns 0
Single number returns that number: "5" → 5
Two numbers comma-separated: "1,2" → 3
Handle multiple numbers: "1,2,3,4" → 10
Handle newlines as delimiters: "1\n2,3" → 6
     */

    @Test
    @DisplayName("Calculator.add() - when the input string is null or empty, the add(String str) method should return 0")
    void addShouldReturnZeroWhenEmptyString(){
        //given
        Calculator calc = new Calculator();

        //when
        int result = calc.add("");

        //then
        assertEquals(0, result);
    }
    @Test
    @DisplayName("Calculator.add() - when the input string is representing a number, the add(String str) method should return this number")
    void addShouldReturnNumberIfOnlyOneNumber(){
        //given
        Calculator calc = new Calculator();

        //when
        int result = calc.add("5");

        //then
        assertEquals(5, result);
    }


}
