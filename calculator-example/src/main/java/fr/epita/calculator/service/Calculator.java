package fr.epita.calculator.service;

public class Calculator {
    public double divide(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        return ((double)operand1) / operand2;
    }

    public int add(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        String[] numbers = s.split(",");
        if (numbers.length == 1) {
            return Integer.parseInt(s);
        } else {
            throw new IllegalStateException("not yet implemented");
        }
    }
}
