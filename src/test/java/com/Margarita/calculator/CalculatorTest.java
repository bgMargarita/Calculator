package com.Margarita.calculator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Batman on 09.12.2018.
 */
public class CalculatorTest {

    List<String> list = new ArrayList<>();
    private Calculator calculator = new Calculator();


    @Test
    public void getPriority() throws Exception {
        assertTrue(calculator.getPriority("+") == 1);
        assertTrue(calculator.getPriority("*") == 2);
        assertTrue(calculator.getPriority("/") == 2);
        assertFalse(calculator.getPriority(")") == 2);
        assertFalse(calculator.getPriority("^") == 3);
        assertTrue(calculator.getPriority("-") == 1);
    }

    @Test
    public void calculate() {

    }


    @Test
    public void calculatePostfix() throws Exception {
        List<String> answ = new ArrayList<>();
        answ.add("7");
        answ.add("2");
        answ.add("3");
        answ.add("*");
        answ.add("-");
        list.add("7");
        list.add("-");
        list.add("2");
        list.add("*");
        list.add("3");
        System.out.println(list);
        System.out.println(calculator.calculatePostfix(answ));
        //System.out.println(calculator.calculatePostfix(calculator.calculate(list)));
        // assertTrue(calculator.calculatePostfix(calculator.writeToStack(list)) == 1.0);

    }

}