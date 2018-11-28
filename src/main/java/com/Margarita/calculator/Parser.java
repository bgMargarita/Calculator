package com.Margarita.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Batman on 27.11.2018.
 */
public class Parser {

    private static final Map<String, Integer> OPERATION_PRIORITY = new HashMap<String, Integer>();

    static {
        OPERATION_PRIORITY.put("*", 1);
        OPERATION_PRIORITY.put("/", 1);
        OPERATION_PRIORITY.put("+", 2);
        OPERATION_PRIORITY.put("-", 2);
    }

    String line;

    public List<String> StringToArray(String str) {
        return Arrays.asList(str.split(" "));

    }

    public void WriteToStack(List<String> str) {
        Stack stack = new Stack();
        List<String> postfixString = new ArrayList<String>();
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i).matches("[-+]?\\d+"))
                stack.push(str.get(i));
            else if (str.get(i) == "(")
                stack.push(str.get(i));
            else if (str.get(i) == ")") {
                stack.push(str.get(i));
                while (stack.lastElement() != "(") {
                    postfixString.add(stack.pop().toString());
                }
                stack.pop();
            }
           /* else{ while(!stack.isEmpty() && stack.lastElement())

            } выбор приоритетной функции
*/
        }
    }

    public List<String> ReadFromFile(String filename) {
        List<String> stringsFromFile = new ArrayList<String>();
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader(filename));
            while ((line = readFromFile.readLine()) != null) {
                stringsFromFile.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringToArray(stringsFromFile.get(stringsFromFile.size() - 1));
    }


}
