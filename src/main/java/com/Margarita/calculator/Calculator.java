package com.Margarita.calculator;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by Batman on 28.11.2018.
 */
public class Calculator {

    private static final Map<String, Integer> OPERATION_PRIORITY = new HashMap<String, Integer>();

    private int getPriority(String operator) {
        if (operator.equals("+") || operator.equals("-"))
            return 2;
        else if (operator.equals("*") || operator.equals("/"))
            return 1;
        else return 0;
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
            else if (str.get(i).equals("("))
                stack.push(str.get(i));
            else if (str.get(i).equals(")")) {
                while (!str.get(i).equals("(")) {
                    postfixString.add(stack.pop() + " ");
                }
                stack.pop();
            } else if (isOperator(str.get(i))) {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(str.get(i))) {
                    postfixString.add(stack.pop() + " ");
                }
                stack.push(str.get(i));
            }
        }
        return postfixString;
    }

    public int calculatePostfix(String postfix) {


    }
}
