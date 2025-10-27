package fr.epita.calculator.service;

public class Factorial {

    /**
     * Factorial implementation, iterative
     * @param n in case of a negative number, a IllegalArgumentException is thrown
     * @return the factorial result (positive integer)
     */
    public static int factorial(int n) {
        int result = 1;
        if (n < 0){
            throw new IllegalArgumentException("Negative number");
        }
        for (int i = n; i > 0 ; i-- ) {
            result *= i;
        }
        return result;
    }
}
