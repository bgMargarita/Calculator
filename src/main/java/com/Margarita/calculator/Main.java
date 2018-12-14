package com.Margarita.calculator;

/**
 * Created by Batman on 03.12.2018.
 */
public class Main {

    public static void main(String args[]) {
        Calculator c = new Calculator();
        Parser p = new Parser();
        Writer w = new Writer();

        // w.writeToFile(c.calculatePostfix(c.writeToStack(p.readFromFile("file.txt").get(0))));
    }
}
