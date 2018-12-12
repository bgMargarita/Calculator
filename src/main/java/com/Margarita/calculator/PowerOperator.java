package com.Margarita.calculator;

/**
 * Created by Batman on 09.12.2018.
 */
public class PowerOperator implements Operator {

    @Override
    public double evaluate(double a, double b) {
        return Math.pow(a, b);
    }
}
