package com.Margarita.calculator;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Batman on 28.11.2018.
 */
public class Calculator {

    private int calculate(Integer operand1, Integer operand2, String operator) {
        if (operator.equals("+")) {
            return (operand1 + operand2);
        }
        if (operator.equals("-")) {
            return (operand1 - operand2);
        }
        if (operator.equals("*")) {
            return (operand1 * operand2);
        }
        if (operator.equals("/")) {
            return (operand1 / operand2);
        }
    }

    private int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 2;
        if (operator.equals("*") || operator.equals("/"))
            return 1;
        return 0;
    }

    private boolean isOperator(String operator) {
        return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }

    public List<String> writeToStack(List<String> str) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postfixString = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).matches("[-+]?\\d+"))
                postfixString.add(str.get(i));
            if (str.get(i).equals("("))
                stack.push(str.get(i));
            if (str.get(i).equals(")")) {
                while (!str.get(i).equals("(")) {
                    postfixString.add(stack.pop() + " ");
                }
                stack.pop();
            }
            if (isOperator(str.get(i))) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(str.get(i))) {
                    postfixString.add(stack.pop() + " ");
                }
                stack.push(str.get(i));
            }
        }
        return postfixString;
    }

    public int calculatePostfix(List<String> postfix) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (String i : postfix) {
            if (i.matches("[-+]?\\d+"))
                stack.push(parseInt(i));

            else {
                int temp = stack.pop();
                stack.push(calculate(temp, stack.pop(), i));
            }
        }
        return stack.peek();


    }
}
