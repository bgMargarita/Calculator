package com.Margarita.calculator;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Batman on 03.12.2018.
 */
public class Writer {
    public void writeToFile(Double answ) {
        try (FileWriter writer = new FileWriter("Answer.txt", false)) {
            writer.write(answ.toString());
            writer.append('\n');

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        Calculator c = new Calculator();
        Parser p = new Parser();
        Writer w = new Writer();
        w.writeToFile(c.calculatePostfix(c.writeToStack(p.readFromFile("file.txt").get(0))));
    }
}
