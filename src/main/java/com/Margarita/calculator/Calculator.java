package com.Margarita.calculator;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Batman on 28.11.2018.
 */
public class Calculator {

    private static Map<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", new PlusOperator());
        operators.put("-", new MinusOperator());
        operators.put("/", new DivisionOperator());
        operators.put("*", new MultiplyOperator());
    }

    private Double calculate(Double operand1, Double operand2, String operator) {
        return (operators.get(operator).evaluate(operand1, operand2));
    }

    public int getPriority(String operator) {
        if (operator.equals("+")) {
            return 1;
        }
        if (operator.equals("*")) {
            return 3;
        }
        if (operator.equals("-")) {
            return 2;
        }
        if (operator.equals("/")) {
            return 4;
        }
        return 0;
    }

    private boolean isOperator(String operator) {
        return (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"));
    }

    public List<String> writeToStack(List<String> str) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postfixString = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).matches("[-+]?\\d+")) {
                postfixString.add(str.get(i));
            }
            if (str.get(i).equals("(")) {
                stack.push(str.get(i));
            }
            if (str.get(i).equals(")")) {
                while (!(stack.peek().equals("("))) {
                    postfixString.add(stack.pop());
                }
                stack.pop();
            }
            if (isOperator(str.get(i))) {
                while (!stack.isEmpty() && (getPriority(stack.peek()) >= getPriority(str.get(i)))) {
                    postfixString.add(stack.pop());
                }
                stack.push(str.get(i));
            }
        }
        while (!(stack.isEmpty())) {
            postfixString.add(stack.pop());
        }
        return postfixString;
    }

    public Double calculatePostfix(List<String> postfix) {

        Deque<Double> stack = new ArrayDeque<>();
        for (String i : postfix) {
            if (i.matches("[-+]?\\d+"))
                stack.push(Double.parseDouble(i));

            else {
                Double temp = stack.pop();
                stack.push(calculate(stack.pop(), temp, i));
            }
        }
        return stack.peek();
    }
}
