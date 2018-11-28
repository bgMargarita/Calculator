package com.Margarita.calculator;

import java.util.*;

/**
 * Created by Batman on 28.11.2018.
 */
public class Calculator {
    private static final Map<String, Integer> OPERATION_PRIORITY = new HashMap<String, Integer>();

    static {
        OPERATION_PRIORITY.put("*", 1);
        OPERATION_PRIORITY.put("/", 1);
        OPERATION_PRIORITY.put("+", 2);
        OPERATION_PRIORITY.put("-", 2);
    }
    public   List<String> writeToStack(List<String> str) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> postfixString = new ArrayList<>();
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).matches("[-+]?\\d+"))
                stack.push(str.get(i));
            else if (str.get(i).equals("("))
                stack.push(str.get(i));
            else if (str.get(i).equals(")")) {
                stack.push(str.get(i));
                while (!str.get(i).equals("(")) {
                    postfixString.add(stack.pop());
                }
                stack.pop();
            }
           /* else{ while(!stack.isEmpty() && stack.lastElement())

            } выбор приоритетной функции
*/
        }
        return postfixString;
    }

}
