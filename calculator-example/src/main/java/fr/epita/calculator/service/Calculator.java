package fr.epita.calculator.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);


    public double divide(int operand1, int operand2) {
        if (operand2 == 0) {
            logger.error("Divide by zero");
            throw new ArithmeticException("Divide by zero");
        }
        return ((double)operand1) / operand2;
    }

    public int add(String s) {
        logger.debug("entering add with parameters {}", s);
        if ("".equals(s) || s == null) {
            logger.warn("input was empty or null");
            return 0;
        }
        String[] numbers = s.split(",");
        if (numbers.length == 1) {
            logger.debug("returning  {}", s);
            return Integer.parseInt(s);
        } else {
            logger.error("this is not implemented");
            throw new IllegalStateException("not yet implemented");
        }
    }
}
