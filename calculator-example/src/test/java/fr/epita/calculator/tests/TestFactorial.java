package fr.epita.calculator.tests;

import fr.epita.calculator.service.Factorial;

public class TestFactorial {

    public static void main(String[] args) {
        nominal();
        edge();
    }

    private static void edge() {
        //given
        int number = -2;

        //when
        int result = Factorial.factorial(number);

        //then
        System.out.println("exception expected");
    }

    private static void nominal() {
        //given
        int number = 5;

        //when
        int result = Factorial.factorial(number);

        //then
        if (result == 120) {
            System.out.println("test succeeded");
        }
    }
}
