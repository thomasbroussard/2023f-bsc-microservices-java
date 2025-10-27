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
        Exception collectedException = null;
        try {
            int result = Factorial.factorial(number);
        }catch (Exception e) {
            collectedException = e;
        }
        //then
        Assertions.assertNotNull(collectedException);
        Assertions.assertTrue(collectedException instanceof IllegalArgumentException);
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
