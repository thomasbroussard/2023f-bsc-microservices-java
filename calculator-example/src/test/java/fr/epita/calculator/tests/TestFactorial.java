package fr.epita.calculator.tests;

import fr.epita.calculator.service.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFactorial {

    @Test
    public void edge() {
        //given
        int number = -2;

        //when
        int result = Factorial.factorial(number);

        //then
        System.out.println("exception expected");
    }

    @Test
    public void nominal() {
        //given
        int number = 5;

        //when
        int result = Factorial.factorial(number);

        //then
        Assertions.assertEquals(120, result);
    }
}
