package com.Margarita.calculator;

/**
 * Created by Batman on 30.11.2018.
 */
public class MultiplyOperator implements Operator {
    @Override
    public double evaluate(double a, double b){
        return a*b;
    }
}
